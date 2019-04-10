package movie.bw.com.shopcar.mvp.model;

/**
 * @Author：梁金子
 * @Date：2019/4/3 16:01
 * @Description：描述信息
 */
public interface MainModel {

    interface CallBackListener{
        void success(int type,String data);
        void fail(int type,String error);
    }

    void doShopCar(int type,String url,CallBackListener callBackListener);
}
