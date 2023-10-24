package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.ViagemDAO;

public class BancoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco);
        ViagemDAO dao = new ViagemDAO(BancoActivity.this);
        try {
            dao.AbrirBanco();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
