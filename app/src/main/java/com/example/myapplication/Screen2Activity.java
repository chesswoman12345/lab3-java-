package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    private TextView recapr;
    private Button btnRetourr;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        recapr = findViewById(R.id.recap);
        btnRetourr = findViewById(R.id.btnRetour);

        Intent startIntent = getIntent();

        String nom     = startIntent.getStringExtra("nom");
        String email   = startIntent.getStringExtra("email");
        String phone   = startIntent.getStringExtra("phone");
        String adresse = startIntent.getStringExtra("adresse");
        String ville   = startIntent.getStringExtra("ville");

        String resume = "Nom : " + safe(nom) +
                "\nEmail : " + safe(email) +
                "\nPhone : " + safe(phone) +
                "\nAdresse : " + safe(adresse) +
                "\nVille : " + safe(ville);

        recapr.setText(resume);

        btnRetourr.setOnClickListener(v -> finish());
    }

    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}
