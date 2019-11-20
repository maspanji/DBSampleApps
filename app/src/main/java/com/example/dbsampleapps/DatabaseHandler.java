package com.example.dbsampleapps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "BukuManager";

    private static final String TABLE_BUKU = "t_buku";

    private static final String KEY_ID = "id";
    private static final String KEY_JUDUL = "judul";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_BUKU = "CREATE TABLE "+TABLE_BUKU+"(id INTEGER PRIMARY KEY , judul TEXT)";
        db.execSQL(CREATE_TABLE_BUKU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUKU);
        onCreate(db);
    }

    public void saveBuku(Buku buku){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_JUDUL, buku.getJudul());

        db.insert(TABLE_BUKU,null, values);
        db.close();
    }

    public List<Buku> findAll(){
        List<Buku> listBuku = new ArrayList<Buku>();
        String query = "SELECT * FROM "+TABLE_BUKU;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Buku buku = new Buku();
                buku.setId(Integer.valueOf(cursor.getString(0)));
                buku.setJudul(cursor.getString(1));
                listBuku.add(buku);
            }while (cursor.moveToNext());
        }
        return listBuku;
    }

    public void delete(Buku buku){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_BUKU, KEY_ID+"=?", new String[]{String.valueOf(buku.getId())});
        db.close();
    }



}
