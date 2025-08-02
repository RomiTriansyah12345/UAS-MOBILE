package com.example.uasmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Daftar extends AppCompatActivity {

    TextView textNama, textEmail;
    Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        // Inisialisasi View
        textNama = findViewById(R.id.textNama);
        textEmail = findViewById(R.id.textEmail);
        btnKembali = findViewById(R.id.btnKembali);

        // Ambil data dari Intent
        String nama = getIntent().getStringExtra("nama");
        String email = getIntent().getStringExtra("email");

        // Tampilkan data
        textNama.setText("Nama: " + nama);
        textEmail.setText("Email: " + email);

        // Load animasi dari folder res/anim
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in_zoom);
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        Animation bounceIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_scale);

        // Jalankan animasi
        textNama.startAnimation(fadeIn);
        textEmail.startAnimation(slideUp);
        btnKembali.startAnimation(bounceIn);

        // Tombol kembali ke login
        btnKembali.setOnClickListener(v -> {
            Intent intent = new Intent(Daftar.this, MainActivity.class);
            startActivity(intent);
            finish(); // tutup halaman ini
        });
    }
}
