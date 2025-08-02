package com.example.uasmobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button btnLogin, btnRegister;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi komponen dari layout XML
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.Login);
        btnRegister = findViewById(R.id.regist);

        // Aksi tombol login
        btnLogin.setOnClickListener(v -> {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            // Validasi sederhana (boleh kamu tambah sesuai kebutuhan)
            if (email.equals("admin@gmail.com") && password.equals("123456")) {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            } else {
                editTextEmail.setError("Email/Password salah");
                editTextPassword.setError("Email/Password salah");
            }
        });

        // Aksi tombol register
        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);

            ImageView logoImage = findViewById(R.id.logoImage);
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_in_zoom);
            logoImage.startAnimation(anim);

        });
    }
}
