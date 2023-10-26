package com.example.myapplication.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.database.model.UsuarioModel;
import com.example.myapplication.database.model.ViagemModel;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NOME = "banco.db";
    private static final int DATABASE_VERSAO = 2;

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioModel.CREATE_TABLE);
        db.execSQL(ViagemModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(ViagemModel.CREATE_TABLE);
            db.execSQL(UsuarioModel.CREATE_TABLE);
    }
}
