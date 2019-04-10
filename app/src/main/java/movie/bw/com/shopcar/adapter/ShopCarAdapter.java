package movie.bw.com.shopcar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import movie.bw.com.shopcar.R;
import movie.bw.com.shopcar.bean.ShopCarBean;

/**
 * @Author：梁金子
 * @Date：2019/4/7 8:43
 * @Description：最外层的适配器 用来展示商家
 */
public class ShopCarAdapter extends RecyclerView.Adapter<ShopCarAdapter.ShopCarViewHolder> {
    private Context context;
    private List<ShopCarBean.DataBean> list=new ArrayList<>();
    private TextView mtitle;
    private RecyclerView mRecycler;

    public ShopCarAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ShopCarAdapter.ShopCarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.adapter_item,null);
        ShopCarViewHolder shopCarViewHolder=new ShopCarViewHolder(view);

        return shopCarViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopCarViewHolder shopCarViewHolder, int i) {
        shopCarViewHolder.mtitle.setText(list.get(i).getSellerName());//设置商家名字
        List<ShopCarBean.DataBean.ListBean> listShop = this.list.get(i).getList();//获取商品集合
        ShopCarItemAdapter shopCarItemAdapter = new ShopCarItemAdapter(context,listShop);
//        布局
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        shopCarViewHolder.mRecycler.setLayoutManager(linearLayoutManager);
        shopCarViewHolder.mRecycler.setAdapter(shopCarItemAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
//    传递数据
    public void setList(List<ShopCarBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ShopCarViewHolder extends RecyclerView.ViewHolder {
        TextView mtitle;
        RecyclerView mRecycler;
        public ShopCarViewHolder(@NonNull View itemView) {
            super(itemView);
            mtitle = (TextView) itemView.findViewById(R.id.tv_title);
            mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);

        }
    }
}
