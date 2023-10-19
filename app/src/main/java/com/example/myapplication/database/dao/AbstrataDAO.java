package com.example.bancomobile.database.dao;

import android.database.sqlite.SQLiteDatabase;

import com.example.bancomobile.database.helper.DBOpenHelper;

import java.sql.SQLException;

public class AbstrataDAO {
    protected SQLiteDatabase db;
    protected DBOpenHelper db_helper;

    protected final void Open() throws SQLException {
        db = db_helper.getWritableDatabase();
    }

    protected final void Close() throws SQLException {
        db_helper.close();
    }
}
