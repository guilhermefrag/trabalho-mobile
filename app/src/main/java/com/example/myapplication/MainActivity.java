package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnSair, btnMinhasViagens, btnCadastrarViagem,
            btnVisualizarbanco;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);

        btnCadastrarViagem = findViewById(R.id.btnCadastrarViagem);
        btnMinhasViagens = findViewById(R.id.btnMinhasViagens);
        btnSair = findViewById(R.id.btnSair);
        btnVisualizarbanco = findViewById(R.id.btnVisualizarbanco);

        btnCadastrarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroViagemActivity.class);
                startActivity(intent);
            }
        });
        btnMinhasViagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MinhasViagens.class);
                startActivity(intent);
            }
        });
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("lembrar_senha", false);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        btnVisualizarbanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BancoActivity.class);
                startActivity(intent);
            }
        });
    }
}