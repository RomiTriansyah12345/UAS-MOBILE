package com.example.uasmobile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListPinjamActivity extends AppCompatActivity {

    ListView listViewPinjaman;
    ArrayList<String> daftarPinjaman;
    ArrayAdapter<String> adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pinjam);

        listViewPinjaman = findViewById(R.id.btnListPinjam);

        // Inisialisasi array kosong
        daftarPinjaman = new ArrayList<>();

        // Adapter kosong, bisa ditambahkan data nanti
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                daftarPinjaman
        );

        listViewPinjaman.setAdapter(adapter);
    }

    // Metode ini bisa kamu panggil dari Activity lain untuk menambahkan data ke list
    public void tambahPinjaman(String data) {
        daftarPinjaman.add(data);
        adapter.notifyDataSetChanged();
    }
}
