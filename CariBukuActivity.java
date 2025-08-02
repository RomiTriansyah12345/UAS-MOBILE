package com.example.uasmobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uasmobile.R;

public class CariBukuActivity extends AppCompatActivity {

    EditText etJudulBuku;
    Button btnCari, btnPinjam;
    TextView tvHasilRak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_buku);

        etJudulBuku = findViewById(R.id.etJudulBuku);
        btnCari = findViewById(R.id.btnCari);
        btnPinjam = findViewById(R.id.btnPinjam);
        tvHasilRak = findViewById(R.id.tvHasilRak);

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = etJudulBuku.getText().toString().trim();
                if (judul.isEmpty()) {
                    Toast.makeText(CariBukuActivity.this, "Masukkan judul buku", Toast.LENGTH_SHORT).show();
                } else {
                    // Contoh: hasil dummy
                    if (judul.equalsIgnoreCase("buku fisika")) {
                        tvHasilRak.setText("Rak A3");
                    } else if (judul.equalsIgnoreCase("buku matematika")) {
                        tvHasilRak.setText("Rak B1");
                    } else {
                        tvHasilRak.setText("Tidak ditemukan");
                    }
                }
            }
        });

        btnPinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lokasi = tvHasilRak.getText().toString();
                if (lokasi.equals("Tidak ditemukan") || lokasi.isEmpty()) {
                    Toast.makeText(CariBukuActivity.this, "Buku belum ditemukan!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CariBukuActivity.this, "Buku berhasil dipinjam!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}