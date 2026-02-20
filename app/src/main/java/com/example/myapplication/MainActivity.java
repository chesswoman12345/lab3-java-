package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText namer, emailr, phoner, adresser, viller;

    private Button btnEnvoyerr;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namer = findViewById(R.id.nom);
        emailr = findViewById(R.id.email);
        phoner = findViewById(R.id.phone);
        adresser = findViewById(R.id.adresse);
        viller = findViewById(R.id.ville);
        btnEnvoyerr = findViewById(R.id.btnEnvoyer);

        btnEnvoyerr.setOnClickListener(v -> {
            String sNomr = namer.getText().toString().trim();
            String sEmailr   = emailr.getText().toString().trim();
            String sPhoner   = phoner.getText().toString().trim();
            String sAdresser = adresser.getText().toString().trim();
            String sViller   = viller.getText().toString().trim();

            if (sNomr.isEmpty() || sEmailr.isEmpty()){
                Toast.makeText(this, "Nom & email sont obligatoires. :)", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent bda = new Intent(MainActivity.this, Screen2Activity.class);

            bda.putExtra("nom", sNomr);
            bda.putExtra("email", sEmailr);
            bda.putExtra("phone", sPhoner);
            bda.putExtra("adresse", sAdresser);
            bda.putExtra("ville", sViller);

            startActivity(bda);
        });
    }
}
