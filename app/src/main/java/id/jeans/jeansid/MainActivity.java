package id.jeans.jeansid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import id.jeans.jeansid.adapter.ProductAdapter;
import id.jeans.jeansid.model.Product;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView, recyclerViewHorizontal;
    private RecyclerView.Adapter adapter,adapterCategory;

    private ArrayList<Product> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        listItems = new ArrayList<>();
        listItems.add(new Product("https://uniqlo.scene7.com/is/image/UNIQLO/goods_65_408350?$pdp-medium$","Straight Jeans","RP 150.000","Stop wearing jeans that don't fit and get custom-made, pre-washed jeans made exclusively for you.\n" +
                "100% Fit Guarantee - If you're not satisfied with the fit, simply let us know and we'll give you a free remake.\n" +
                "Jeans made of premium stretch fabric."));
        listItems.add(new Product("https://dimg.dillards.com/is/image/DillardsZoom/nav/polo-ralph-lauren-hampton-straight-fit-lightweight-morris-wash-jeans/04330434_zi_lightweight_morris.jpg","Straight Jeans","RP 150.000","Stop wearing jeans that don't fit and get custom-made, pre-washed jeans made exclusively for you.\n" +
                "100% Fit Guarantee - If you're not satisfied with the fit, simply let us know and we'll give you a free remake.\n" +
                "Jeans made of premium stretch fabric."));
        listItems.add(new Product("https://uniqlo.scene7.com/is/image/UNIQLO/goods_65_408350?$pdp-medium$","Straight Jeans","RP 150.000","Stop wearing jeans that don't fit and get custom-made, pre-washed jeans made exclusively for you.\n" +
                "100% Fit Guarantee - If you're not satisfied with the fit, simply let us know and we'll give you a free remake.\n" +
                "Jeans made of premium stretch fabric."));
        adapter = new ProductAdapter(this,listItems) ;
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            sendToLogin();
        }

    }

    private void sendToLogin() {
        Intent intent = new Intent(MainActivity.this, LandingActivity.class);
        startActivity(intent);
    }
}
