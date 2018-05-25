package id.jeans.jeansid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.jeans.jeansid.ProductDetailActivity;
import id.jeans.jeansid.R;
import id.jeans.jeansid.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    public static final String KEY_PRODUCT="Product";

    private final Context context;
    private final List<Product> listProducts;

    public ProductAdapter(Context context, List<Product> listProducts) {
        this.context = context;
        this.listProducts = listProducts;
    }


    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_product, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nama_product)
        TextView mProductName;
        @BindView(R.id.harga_product) TextView mPriceProduct;
        @BindView(R.id.gambar_product)
        ImageView mImageProduct;
        @BindView(R.id.cardProduct)
        LinearLayout mCardProduct;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        final Product productItem = listProducts.get(position);

        Glide.with(context)
                .load(productItem.getGambarProduct())
                .into(holder.mImageProduct);
        holder.mProductName.setText(productItem.getNamaProduct());

        holder.mPriceProduct.setText(productItem.getHargaProduct());

        holder.mCardProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra(KEY_PRODUCT,productItem);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

}
