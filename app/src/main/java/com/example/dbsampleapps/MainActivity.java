package com.example.dbsampleapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        Log.d("DBLOG","INSERTING DATA");
        databaseHandler.saveBuku(new Buku(1,"Android Programming 3"));
        databaseHandler.saveBuku(new Buku(2,"Android Programming 4"));
        Log.d("DBLOG","READING DATA");
        List<Buku> listBuku = databaseHandler.findAll();
        for(Buku buku : listBuku){
            Log.d("DBLOG","Data: "+buku.getId()+ " - "+buku.getJudul());
        }

    }
}
