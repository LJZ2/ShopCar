package movie.bw.com.shopcar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import movie.bw.com.shopcar.R;
import movie.bw.com.shopcar.bean.ShopCarBean;

/**
 * @Author：梁金子
 * @Date：2019/4/7 9:57
 * @Description：展示商品
 */
public class ShopCarItemAdapter extends RecyclerView.Adapter<ShopCarItemAdapter.ShopCarItemViewHolder> {
    private Context context;
    private List<ShopCarBean.DataBean.ListBean> listShop;

    public ShopCarItemAdapter(Context context, List<ShopCarBean.DataBean.ListBean> listShop) {
        this.context = context;
        this.listShop = listShop;
    }

    @NonNull
    @Override
    public ShopCarItemAdapter.ShopCarItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context, R.layout.adapter_item_child,null);
        ShopCarItemViewHolder shopCarItemViewHolder = new ShopCarItemViewHolder(view);
        return shopCarItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopCarItemAdapter.ShopCarItemViewHolder shopCarViewHolder, int i) {
        Glide.with(context).load(listShop.get(i).getImages()).into(shopCarViewHolder.mImage);
        shopCarViewHolder.mTitle.setText(listShop.get(i).getTitle());
        shopCarViewHolder.mPrice.setText(listShop.get(i).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return listShop.size();
    }

    public class ShopCarItemViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        TextView mTitle,mPrice;

        public ShopCarItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.iv_shop);
            mTitle = itemView.findViewById(R.id.tv_title);
            mPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
