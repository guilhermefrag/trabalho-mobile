package com.example.myapplication.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.myapplication.database.helper.DBOpenHelper;
import com.example.myapplication.database.model.EntretenimentoModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntretenimentoDAO extends AbstrataDAO {

    private final String[] colunas = {
        EntretenimentoModel.COLUNA_ID,
        EntretenimentoModel.COLUNA_DESCRICAO,
        EntretenimentoModel.COLUNA_CUSTO,
        EntretenimentoModel.COLUNA_TOTAL_DE_NOITES,
        EntretenimentoModel.COLUNA_VIAGEM_ID
    };

    public EntretenimentoDAO(Context context) {
        db_helper = new DBOpenHelper(context);
    }

    public boolean integerToBoolean(int value) {
        return value == 1;
    }

    public int booleanToInteger(boolean value) {
        return value ? 1 : 0;
    }

    public long Insert(EntretenimentoModel model) throws SQLException {
        long rowAffect = 0;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(EntretenimentoModel.COLUNA_DESCRICAO, model.getDescricao());
            values.put(EntretenimentoModel.COLUNA_CUSTO, model.getCusto());
            values.put(EntretenimentoModel.COLUNA_TOTAL_DE_NOITES, model.getTotalDeNoites());
            values.put(EntretenimentoModel.COLUNA_VIAGEM_ID, model.getViagemId());

            rowAffect = db.insert(EntretenimentoModel.TABELA_NOME, null, values);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Close();
        }

        return rowAffect;
    }

    public List<EntretenimentoModel> selectAllFromViagem(int idViagem) throws SQLException {
        List<EntretenimentoModel> lista = new ArrayList<>();

        try {
            Open();
            String selection = EntretenimentoModel.COLUNA_VIAGEM_ID + " = ?";
            String[] selectionArgs = { String.valueOf(idViagem) };
            Cursor cursor = db.query(EntretenimentoModel.TABELA_NOME, colunas, selection, selectionArgs, null, null, null);
            while (cursor.moveToNext()) {
                lista.add(CursorToStructure(cursor));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Close();
        }

        return lista;
    }

    public List<EntretenimentoModel> retrieve(int idEntretenimento) throws SQLException {
        List<EntretenimentoModel> lista = new ArrayList<>();

        try {
            Open();
            String selection = EntretenimentoModel.COLUNA_ID + " = ?";
            String[] selectionArgs = { String.valueOf(idEntretenimento) };
            Cursor cursor = db.query(EntretenimentoModel.TABELA_NOME, colunas, selection, selectionArgs, null, null, null);
            while (cursor.moveToNext()) {
                lista.add(CursorToStructure(cursor));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Close();
        }

        return lista;
    }

    public void delete(int idEntretenimento) throws SQLException{
        try {
            Open();
            String selection = EntretenimentoModel.COLUNA_ID + " = ?";
            String[] selectionArgs = { String.valueOf(idEntretenimento) };
            db.delete(EntretenimentoModel.TABELA_NOME, selection, selectionArgs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Close();
        }
    }

    public int update(EntretenimentoModel model) throws SQLException {
        int rowAffect = 0;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(EntretenimentoModel.COLUNA_DESCRICAO, model.getDescricao());
            values.put(EntretenimentoModel.COLUNA_CUSTO, model.getCusto());
            values.put(EntretenimentoModel.COLUNA_TOTAL_DE_NOITES, model.getTotalDeNoites());
            values.put(EntretenimentoModel.COLUNA_VIAGEM_ID, model.getViagemId());

            String selection = EntretenimentoModel.COLUNA_ID + " = ?";
            String[] selectionArgs = { String.valueOf(model.getId()) };

            rowAffect = db.update(EntretenimentoModel.TABELA_NOME, values, selection, selectionArgs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Close();
        }

        return rowAffect;
    }

    public final EntretenimentoModel CursorToStructure(Cursor cursor) {
        EntretenimentoModel model = new EntretenimentoModel();
        model.setId(cursor.getInt(0));
        model.setDescricao(cursor.getString(1));
        model.setCusto(cursor.getFloat(2));
        model.setTotalDeNoites(cursor.getInt(3));
        model.setViagemId(cursor.getInt(4));
        return model;
    }

    public void AbrirBanco() throws SQLException {
        Open();
    }

}
