package movie.bw.com.shopcar.mvp.model;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author：梁金子
 * @Date：2019/4/3 16:05
 * @Description：描述信息
 */
public class MainModellml implements MainModel {
    private CallBackListener callBackListener;
    private int type;
    @Override
    public void doShopCar(int type, String url, CallBackListener callBackListener) {
        this.callBackListener=callBackListener;
        this.type=type;
        //        请求购物车数据
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        final Message message=Message.obtain();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                message.what=1001;
                message.obj=e.getMessage();
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                message.what=1000;
                message.obj=response.body().string();
                handler.sendMessage(message);
            }
        });
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1000){
                String data= (String) msg.obj;
                callBackListener.success(type,data);
            }else {
                String error= (String) msg.obj;
                callBackListener.fail(type,error);
            }
        }
    };
}
