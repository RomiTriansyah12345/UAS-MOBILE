package com.example.uasmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {

    // Deklarasi layout menu
    LinearLayout menuDaftar, menuCari, menuInput, menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // Atur padding untuk status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi layout menu
        menuDaftar = findViewById(R.id.menuDaftar);
        menuCari = findViewById(R.id.menuCari);
        menuInput = findViewById(R.id.menuInput);
        menuList = findViewById(R.id.menuList);

        // Load animasi
        Animation animasi = AnimationUtils.loadAnimation(this, R.anim.fade_in_zoom);

        // Terapkan animasi
        menuDaftar.startAnimation(animasi);
        menuCari.startAnimation(animasi);
        menuInput.startAnimation(animasi);
        menuList.startAnimation(animasi);
    }

    // Navigasi tombol
    public void openInputBuku(View view) {
        Intent intent = new Intent(this, InputBuku.class);
        startActivity(intent);
    }

    public void openCariBuku(View view) {
        Intent intent = new Intent(this, CariBukuActivity.class);
        startActivity(intent);
    }

    public void openDaftarBuku(View view) {
        Intent intent = new Intent(this, DaftarBukuActivity.class);
        startActivity(intent);
    }

    public void openListPinjam(View view) {
        Intent intent = new Intent(this, ListPinjamActivity.class);
        startActivity(intent);
    }

    private static class InputBuku {
    }
}
