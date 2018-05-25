package id.jeans.jeansid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.jeans.jeansid.adapter.ProductAdapter;
import id.jeans.jeansid.model.Product;

public class ProductDetailActivity extends AppCompatActivity {

    @BindView(R.id.gambar_product)
    ImageView gambarProduct;
    @BindView(R.id.nama_product)
    TextView namaProduct;
    @BindView(R.id.harga_product) TextView hargaProduct;
    @BindView(R.id.description_product) TextView descriptionProduct;

    String gambar,nama,harga,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_detail);

        ButterKnife.bind(this);

        if (getIntent() != null){
            getData();
            setData();
        }
    }

    private void setData() {
        Glide.with(ProductDetailActivity.this).load(gambar).into(gambarProduct);
        namaProduct.setText(nama);
        hargaProduct.setText(harga);
        descriptionProduct.setText(description);
    }

    private void getData() {
        Product product= getIntent().getExtras().getParcelable(ProductAdapter.KEY_PRODUCT);
        gambar=product.getGambarProduct();
        nama=product.getNamaProduct();
        harga=product.getHargaProduct();
        description=product.getDeskripsiProduct();
    }


}
