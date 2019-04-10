package movie.bw.com.shopcar.mvp.view;

/**
 * @Author：梁金子
 * @Date：2019/4/3 15:59
 * @Description：描述信息
 */
    public interface MainView {

        void success(int type,String data);
        void fail(int type,String error);

}
