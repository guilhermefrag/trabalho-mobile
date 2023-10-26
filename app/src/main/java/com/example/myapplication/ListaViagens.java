package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.database.dao.ViagemDAO;
import com.example.myapplication.database.model.ViagemModel;

import java.sql.SQLException;
import java.util.List;

public class ListaViagens extends AppCompatActivity {

    ViagemDAO viagemDAO = new ViagemDAO(ListaViagens.this);
    List<ViagemModel> viagens;
    SharedPreferences sharedPreferences = getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);
    int idUsuario = sharedPreferences.getInt("id_usuario", -1);

    {
        try {

            viagens = viagemDAO.SelectAllFromUsuario(idUsuario);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
