package com.android.foodorderapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

// là một đối tượng của file json
// chứa các atribute của đối tượng
////Parcelable là gì Parcelable thường được sử dụng để gửi dữ liệu
//// (dạng Object) giữa các activity với nhau thông qua Bunble gửi cùng Intent.
public class RestaurantModel implements Parcelable {
    private String id;
    private String tenBan;
    private String thanhPho;
    private String trangThai;
    private String zip;
    private String phi;
    private String tong;

    public RestaurantModel() {
    }



    public RestaurantModel(String id, String tenBan, String thanhPho, String trangThai, String zip, String phi, String tong, String name, String address, String image, float delivery_charge, Hours hours, List<Menu> menus) {
        this.id = id;
        this.tenBan = tenBan;
        this.thanhPho = thanhPho;
        this.trangThai = trangThai;
        this.zip = zip;
        this.phi = phi;
        this.tong = tong;
        this.name = name;
        this.address = address;
        this.image = image;
        this.delivery_charge = delivery_charge;
        this.hours = hours;
        this.menus = menus;
    }

    public String getPhi() {
        return phi;
    }

    public void setPhi(String phi) {
        this.phi = phi;
    }

    public String getTong() {
        return tong;
    }

    public void setTong(String tong) {
        this.tong = tong;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }


    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;
    private String address;
    private String image;
    private float delivery_charge;
    private Hours hours;
    private List<Menu> menus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(float delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    protected RestaurantModel(Parcel in) {
        name = in.readString();
        address = in.readString();
        image = in.readString();
        delivery_charge = in.readFloat();
        menus = in.createTypedArrayList(Menu.CREATOR);
    }

    public static final Creator<RestaurantModel> CREATOR = new Creator<RestaurantModel>() {
        @Override
        public RestaurantModel createFromParcel(Parcel in) {
            return new RestaurantModel(in);
        }

        @Override
        public RestaurantModel[] newArray(int size) {
            return new RestaurantModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(image);
        dest.writeFloat(delivery_charge);
        dest.writeTypedList(menus);
    }
}
