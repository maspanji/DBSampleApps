package com.example.dbsampleapps;

public class Buku {
    private int id;
    private String judul;

    public Buku(){}

    public Buku(int id, String judul){
        this.id = id;
        this.judul = judul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
