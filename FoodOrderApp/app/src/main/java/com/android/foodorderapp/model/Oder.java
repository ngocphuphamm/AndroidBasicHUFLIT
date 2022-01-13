package com.android.foodorderapp.model;

public class Oder {
    private String id;
    private String name;
    private float price;
    private int totalInCart;
    private String url;
    private String tenBan;
    private String diachi;
    private String thanhPho;
    private String trangThai;
    private String zip;
    private String nhapSo;
    private String thoiHan;
    private String maPin;
    private float phi;
    private float tong;

    public Oder() {
    }

    public Oder(String id, String name, float price, int totalInCart, String url, String tenBan, String diachi, String thanhPho, String trangThai, String zip, String nhapSo, String thoiHan, String maPin, float phi, float tong) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalInCart = totalInCart;
        this.url = url;
        this.tenBan = tenBan;
        this.diachi = diachi;
        this.thanhPho = thanhPho;
        this.trangThai = trangThai;
        this.zip = zip;
        this.nhapSo = nhapSo;
        this.thoiHan = thoiHan;
        this.maPin = maPin;
        this.phi = phi;
        this.tong = tong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTotalInCart() {
        return totalInCart;
    }

    public void setTotalInCart(int totalInCart) {
        this.totalInCart = totalInCart;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
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

    public String getNhapSo() {
        return nhapSo;
    }

    public void setNhapSo(String nhapSo) {
        this.nhapSo = nhapSo;
    }

    public String getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(String thoiHan) {
        this.thoiHan = thoiHan;
    }

    public String getMaPin() {
        return maPin;
    }

    public void setMaPin(String maPin) {
        this.maPin = maPin;
    }

    public float getPhi() {
        return phi;
    }

    public void setPhi(float phi) {
        this.phi = phi;
    }

    public float getTong() {
        return tong;
    }

    public void setTong(float tong) {
        this.tong = tong;
    }
}
