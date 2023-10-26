package com.example.myapplication.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Path;

import com.example.myapplication.database.helper.DBOpenHelper;
import com.example.myapplication.database.model.UsuarioModel;
import com.example.myapplication.database.dao.AbstrataDAO;
import com.example.myapplication.database.model.ViagemModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends AbstrataDAO {
    public final String colunas[] = {
            UsuarioModel.COLUNA_ID,
            UsuarioModel.COLUNA_NOME_COMPLETO,
            UsuarioModel.COLUNA_EMAIL,
            UsuarioModel.COLUNA_IDADE,
            UsuarioModel.COLUNA_SENHA
    };

    public UsuarioDAO(Context context) {
        db_helper = new DBOpenHelper(context);
    }

    public long Insert(UsuarioModel model) throws SQLException {
        long rowAffect = 0;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(UsuarioModel.COLUNA_NOME_COMPLETO, model.getNomeCompleto());
            values.put(UsuarioModel.COLUNA_EMAIL, model.getEmail());
            values.put(UsuarioModel.COLUNA_IDADE, model.getIdade());
            values.put(UsuarioModel.COLUNA_SENHA, model.getSenha());

            rowAffect = db.insert(UsuarioModel.TABELA_NOME, null, values);
        } finally {
            Close();
        }

        return rowAffect;
    }

    public List<UsuarioModel> SelectAll() throws SQLException {
        List<UsuarioModel> lista = new ArrayList<>();
        try {
            Open();

            Cursor cursor = db.query(UsuarioModel.TABELA_NOME, colunas, null, null, null, null, null);

            while (!cursor.isAfterLast()) {
                lista.add(CursorToStructure(cursor));
                cursor.moveToNext();
            }

        } finally {
            Close();
        }

        return lista;
    }

    public List<UsuarioModel> GetByEmail(final String email) throws SQLException {
        List<UsuarioModel> lista = new ArrayList<>();

        try {
            Open();
            Cursor cursor = db.query(UsuarioModel.TABELA_NOME, colunas, UsuarioModel.COLUNA_EMAIL + " = ?", new String[]{email}, null, null, null);
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                lista.add(CursorToStructure(cursor));
                cursor.moveToNext();
            }
        } finally {
            Close();
        }

        return lista;
    }

    public List<UsuarioModel> Login(String email, String senha) throws SQLException {
        List<UsuarioModel> lista = new ArrayList<>();

        try {
            Open();
            String selection = UsuarioModel.COLUNA_EMAIL + " = ? AND " + UsuarioModel.COLUNA_SENHA + " = ?";
            String[] selectionArgs = {email, senha};

            Cursor cursor = db.query(UsuarioModel.TABELA_NOME, colunas, selection, selectionArgs, null, null, null);

            while (cursor.moveToNext()) {
                lista.add(CursorToStructure(cursor));
            }
        } finally {
            Close();
        }

        return lista;
    }

    public final UsuarioModel CursorToStructure(Cursor cursor) {
        UsuarioModel model = new UsuarioModel();
        model.setId(cursor.getLong(0));
        model.setNomeCompleto(cursor.getString(1));
        model.setEmail(cursor.getString(2));
        model.setIdade(cursor.getInt(3));
        model.setSenha(cursor.getString(4));

        return model;
    }
}
