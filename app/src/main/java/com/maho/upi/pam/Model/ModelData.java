package com.maho.upi.pam.Model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("ALL")
public class ModelData {


    @SerializedName("id") //convert jsonobjet from gson to android
    String id; //Inisialiasi model
    @SerializedName("ikon")
    String ikon;
    @SerializedName("gambar")
    String  gambar;
    @SerializedName("nama")
    String nama;
    @SerializedName("nomor")
    String nomor;
    @SerializedName("age")
    String age;
    @SerializedName("team")
    String tim;
    @SerializedName("posisi")
    String posisi;
    @SerializedName("negara")
    String negara;
    @SerializedName("deskripsi")
    String deskripsi;


    //Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIkon() {
        return ikon;
    }

    public void setIkon(String ikon) {
        this.ikon = ikon;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
