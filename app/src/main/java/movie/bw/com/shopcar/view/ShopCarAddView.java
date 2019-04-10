package movie.bw.com.shopcar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import movie.bw.com.shopcar.R;

/**
 * @Author：梁金子
 * @Date：2019/4/7 10:25
 * @Description：自定义加减器
 */
public class ShopCarAddView extends RelativeLayout {
    public ShopCarAddView(Context context) {
        super(context);
        init(context);
    }

    public ShopCarAddView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
//    初始化layout
    private void init(Context context) {
        View view = View.inflate(context, R.layout.shop_car_add_view, null);
        addView(view);
    }
}
