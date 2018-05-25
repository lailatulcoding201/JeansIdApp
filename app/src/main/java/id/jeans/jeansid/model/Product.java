package id.jeans.jeansid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    String gambarProduct;
    String namaProduct;
    String hargaProduct;
    String deskripsiProduct;

    public Product() {
    }

    public Product(String gambarProduct, String namaProduct, String hargaProduct, String deskripsiProduct) {
        this.gambarProduct = gambarProduct;
        this.namaProduct = namaProduct;
        this.hargaProduct = hargaProduct;
        this.deskripsiProduct = deskripsiProduct;
    }

    public String getGambarProduct() {
        return gambarProduct;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public String getHargaProduct() {
        return hargaProduct;
    }

    public String getDeskripsiProduct() {
        return deskripsiProduct;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.gambarProduct);
        dest.writeString(this.namaProduct);
        dest.writeString(this.hargaProduct);
        dest.writeString(this.deskripsiProduct);
    }

    protected Product(Parcel in) {
        this.gambarProduct = in.readString();
        this.namaProduct = in.readString();
        this.hargaProduct = in.readString();
        this.deskripsiProduct = in.readString();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
