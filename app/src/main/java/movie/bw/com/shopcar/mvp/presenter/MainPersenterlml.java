package movie.bw.com.shopcar.mvp.presenter;

import movie.bw.com.shopcar.mvp.model.MainModel;
import movie.bw.com.shopcar.mvp.view.MainView;

/**
 * @Author：梁金子
 * @Date：2019/4/3 19:36
 * @Description：描述信息
 */
public class MainPersenterlml implements MainPersenter, MainModel.CallBackListener {
    private MainModel mainModel;
    private MainView mainView;

    public MainPersenterlml(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void doShopCar(int type, String url) {
        mainModel.doShopCar(type,url,this);
    }

    @Override
    public void success(int type, String data) {
        mainView.success(type,data);
    }

    @Override
    public void fail(int type, String error) {
        mainView.fail(type,error);
    }
    public void destory(){
        if (mainView!=null){
            mainView=null;
        }if (mainModel!=null){
            mainModel=null;
        }
        System.gc();
    }
}
