package movie.bw.com.shopcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import movie.bw.com.shopcar.adapter.ShopCarAdapter;
import movie.bw.com.shopcar.bean.ShopCarBean;
import movie.bw.com.shopcar.mvp.model.MainModellml;
import movie.bw.com.shopcar.mvp.presenter.MainPersenter;
import movie.bw.com.shopcar.mvp.presenter.MainPersenterlml;
import movie.bw.com.shopcar.mvp.view.MainView;
//package movie.bw.com.shopcar.bean;
public class MainActivity extends AppCompatActivity implements MainView {


    private MainPersenterlml mainPersenterlml;
    private RecyclerView recyclerView;
    private ShopCarAdapter mshopCarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        找控件
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
//        适配器
        mshopCarAdapter = new ShopCarAdapter(this);
//        布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
//        设置适配器
        recyclerView.setAdapter(mshopCarAdapter);

        mainPersenterlml = new MainPersenterlml(new MainModellml(),this);
        mainPersenterlml.doShopCar(0,"http://172.17.8.100/ks/product/getCarts?uid=51");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPersenterlml.destory();
    }

    @Override
    public void success(int type, String data) {
        ShopCarBean bean = new Gson().fromJson(data, ShopCarBean.class);
        List<ShopCarBean.DataBean> datas = bean.getData();//所有商家及商品集合
        datas.remove(0);
        mshopCarAdapter.setList(datas);
    }

    @Override
    public void fail(int type, String error) {

    }
}
