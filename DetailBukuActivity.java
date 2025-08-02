package com.example.uasmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailBukuActivity extends AppCompatActivity {

    ImageView gambarBuku;
    TextView judulBuku, infoBuku, isiDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        gambarBuku = findViewById(R.id.gambar_buku);
        judulBuku = findViewById(R.id.judul_buku);
        infoBuku = findViewById(R.id.info_buku);
        isiDeskripsi = findViewById(R.id.isi_deskripsi);

        Intent intent = getIntent();
        String judul = intent.getStringExtra("judul");
        String penulis = intent.getStringExtra("penulis");
        String deskripsi = intent.getStringExtra("deskripsi");
        int gambar = intent.getIntExtra("gambar", R.drawable.harry);

        judulBuku.setText(judul);
        infoBuku.setText("Judul : " + judul + "\nPenulis: " + penulis);
        isiDeskripsi.setText(deskripsi);
        gambarBuku.setImageResource(gambar);
    }
}
