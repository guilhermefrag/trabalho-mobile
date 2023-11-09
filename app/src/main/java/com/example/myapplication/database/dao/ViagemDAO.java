package com.example.myapplication.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.myapplication.database.helper.DBOpenHelper;
import com.example.myapplication.database.model.UsuarioModel;
import com.example.myapplication.database.model.ViagemModel;
import com.example.myapplication.database.dao.AbstrataDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViagemDAO extends AbstrataDAO {

    private final String[] colunas = {
            ViagemModel.COLUNA_ID,
            ViagemModel.COLUNA_DESCRICAO,
            ViagemModel.COLUNA_TOTALKM,
            ViagemModel.COLUNA_KMLITRO,
            ViagemModel.COLUNA_CUSTO_MEDIO_LITRO,
            ViagemModel.COLUNA_TOTAL_VEICULOS,
            ViagemModel.COLUNA_TOAL_GASONLINA,
            ViagemModel.COLUNA_ADICIONAR_GASOLINA,
            ViagemModel.COLUNA_CUSTO_TARIFA_PESSOA,
            ViagemModel.COLUNA_ALUGUEL_VEICULO,
            ViagemModel.COLUNA_TOTAL_TARIFA_AEREA,
            ViagemModel.COLUNA_ADICIONAR_TARIFA,
            ViagemModel.COLUNA_CUSTO_REFEICAO,
            ViagemModel.COLUNA_REFEICOES_DIA,
            ViagemModel.COLUNA_TOTAL_REFEICOES,
            ViagemModel.COLUNA_ADICIONAR_REFEICOES,
            ViagemModel.COLUNA_CUSTO_NOITE,
            ViagemModel.COLUNA_TOTAL_NOITES,
            ViagemModel.COLUNA_TOTAL_QUARTOS,
            ViagemModel.COLUNA_TOTAL_HOSPEDAGEM,
            ViagemModel.COLUNA_ADICIONAR_HOSPEDAGEM,
            ViagemModel.COLUNA_ID_USUARIO,
            ViagemModel.COLUNA_TOTAL_VIAJANTES,
            ViagemModel.COLUNA_DURACAO_DIAS
    };

    public ViagemDAO(Context context) {
        db_helper = new DBOpenHelper(context);
    }

    public boolean integerToBoolean(int value) {
        return value == 1;
    }

    public int booleanToInteger(boolean value) {
        return value ? 1 : 0;
    }

    public long Insert(ViagemModel model) throws SQLException {
        long rowAffect = 0;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(ViagemModel.COLUNA_DESCRICAO, model.getDescricao());
            values.put(ViagemModel.COLUNA_TOTALKM, model.getTotalKm());
            values.put(ViagemModel.COLUNA_KMLITRO, model.getKmPorLitro());
            values.put(ViagemModel.COLUNA_CUSTO_MEDIO_LITRO, model.getCustoMedioLitro());
            values.put(ViagemModel.COLUNA_TOTAL_VEICULOS, model.getTotalVeiculos());
            values.put(ViagemModel.COLUNA_TOAL_GASONLINA, model.getTotalGasolina());
            values.put(ViagemModel.COLUNA_ADICIONAR_GASOLINA, model.getAdicionarGasolina());
            values.put(ViagemModel.COLUNA_CUSTO_TARIFA_PESSOA, model.getCustoTarifaPessoa());
            values.put(ViagemModel.COLUNA_ALUGUEL_VEICULO, model.getAluguelVeiculo());
            values.put(ViagemModel.COLUNA_TOTAL_TARIFA_AEREA, model.getTotalTarifaAerea());
            values.put(ViagemModel.COLUNA_ADICIONAR_TARIFA, model.getAdicionarTarifaAerea());
            values.put(ViagemModel.COLUNA_CUSTO_REFEICAO, model.getCustoRefeicao());
            values.put(ViagemModel.COLUNA_REFEICOES_DIA, model.getRefeicoesDia());
            values.put(ViagemModel.COLUNA_TOTAL_REFEICOES, model.getTotalRefeicoes());
            values.put(ViagemModel.COLUNA_ADICIONAR_REFEICOES, model.getAdicionarRefeicoes());
            values.put(ViagemModel.COLUNA_CUSTO_NOITE, model.getCustoNoite());
            values.put(ViagemModel.COLUNA_TOTAL_NOITES, model.getTotalNoites());
            values.put(ViagemModel.COLUNA_TOTAL_QUARTOS, model.getTotalQuartos());
            values.put(ViagemModel.COLUNA_TOTAL_HOSPEDAGEM, model.getTotalHospedagem());
            values.put(ViagemModel.COLUNA_ADICIONAR_HOSPEDAGEM, model.getAdicionarHospedagem());
            values.put(ViagemModel.COLUNA_ID_USUARIO, model.getIdUsuario());
            values.put(ViagemModel.COLUNA_TOTAL_VIAJANTES, model.getTotalViajantes());
            values.put(ViagemModel.COLUNA_DURACAO_DIAS, model.getDuracaoDias());

            rowAffect = db.insert(ViagemModel.TABELA_NOME, null, values);

        } finally {
            Close();
        }

        return rowAffect;
    }

    public List<ViagemModel> SelectAll() throws SQLException {
        List<ViagemModel> lo_arl_dados = new ArrayList<>();

        try {
            Open();

            Cursor cursor = db.query(ViagemModel.TABELA_NOME, colunas, null, null, null, null, null);
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                lo_arl_dados.add(CursorToStructure(cursor));
                cursor.moveToNext();
            }

            cursor.close();

        } finally {
            Close();
        }

        return lo_arl_dados;
    }

    public List<ViagemModel> SelectAllFromUsuario(int idUsuario) throws SQLException {
        List<ViagemModel> lo_arl_dados = new ArrayList<>();
        try {
            Open();
            String selection = ViagemModel.COLUNA_ID_USUARIO + " = ? ";
            String[] selectionArgs = {String.valueOf(idUsuario)};
            Cursor cursor = db.query(ViagemModel.TABELA_NOME, colunas, selection, selectionArgs, null, null, null);

            while (cursor.moveToNext()) {
                lo_arl_dados.add(CursorToStructure(cursor));
            }
        } finally {
            Close();
        }

        return lo_arl_dados;
    }

    public List<ViagemModel> retrieve(String idViagem) throws SQLException {
        List<ViagemModel> viagem = new ArrayList<>();
        try {
            Open();
            String selection = ViagemModel.COLUNA_ID + " = ? ";
            String[] selectionArgs = {String.valueOf(idViagem)};
            Cursor cursor = db.query(ViagemModel.TABELA_NOME, colunas, selection, selectionArgs, null, null, null);

            while (cursor.moveToNext()) {
                viagem.add(CursorToStructure(cursor));
            }
        } finally {
            Close();
        }

        return viagem;
    }

    public int Update(ViagemModel model) throws SQLException {
        int rowsAffected = 0;

        try {
            Open();

            ContentValues values = new ContentValues();
            values.put(ViagemModel.COLUNA_DESCRICAO, model.getDescricao());
            values.put(ViagemModel.COLUNA_TOTALKM, model.getTotalKm());
            values.put(ViagemModel.COLUNA_KMLITRO, model.getKmPorLitro());
            values.put(ViagemModel.COLUNA_CUSTO_MEDIO_LITRO, model.getCustoMedioLitro());
            values.put(ViagemModel.COLUNA_TOTAL_VEICULOS, model.getTotalVeiculos());
            values.put(ViagemModel.COLUNA_TOAL_GASONLINA, model.getTotalGasolina());
            values.put(ViagemModel.COLUNA_ADICIONAR_GASOLINA, model.getAdicionarGasolina());
            values.put(ViagemModel.COLUNA_CUSTO_TARIFA_PESSOA, model.getCustoTarifaPessoa());
            values.put(ViagemModel.COLUNA_ALUGUEL_VEICULO, model.getAluguelVeiculo());
            values.put(ViagemModel.COLUNA_TOTAL_TARIFA_AEREA, model.getTotalTarifaAerea());
            values.put(ViagemModel.COLUNA_ADICIONAR_TARIFA, model.getAdicionarTarifaAerea());
            values.put(ViagemModel.COLUNA_CUSTO_REFEICAO, model.getCustoRefeicao());
            values.put(ViagemModel.COLUNA_REFEICOES_DIA, model.getRefeicoesDia());
            values.put(ViagemModel.COLUNA_TOTAL_REFEICOES, model.getTotalRefeicoes());
            values.put(ViagemModel.COLUNA_ADICIONAR_REFEICOES, model.getAdicionarRefeicoes());
            values.put(ViagemModel.COLUNA_CUSTO_NOITE, model.getCustoNoite());
            values.put(ViagemModel.COLUNA_TOTAL_NOITES, model.getTotalNoites());
            values.put(ViagemModel.COLUNA_TOTAL_QUARTOS, model.getTotalQuartos());
            values.put(ViagemModel.COLUNA_TOTAL_HOSPEDAGEM, model.getTotalHospedagem());
            values.put(ViagemModel.COLUNA_ADICIONAR_HOSPEDAGEM, model.getAdicionarHospedagem());
            values.put(ViagemModel.COLUNA_ID_USUARIO, model.getIdUsuario());
            values.put(ViagemModel.COLUNA_TOTAL_VIAJANTES, model.getTotalViajantes());
            values.put(ViagemModel.COLUNA_DURACAO_DIAS, model.getDuracaoDias());

            String whereClause = ViagemModel.COLUNA_ID + " = ?";
            String[] whereArgs = {String.valueOf(model.getId())};

            rowsAffected = db.update(ViagemModel.TABELA_NOME, values, whereClause, whereArgs);

        } finally {
            Close();
        }

        return rowsAffected;
    }

    public void Delete(final long id) throws SQLException {
        Open();
        db.delete(ViagemModel.TABELA_NOME, ViagemModel.COLUNA_ID + "= ?", new String[]{"" + id});
        Close();
    }

    public void DeleteAll() throws SQLException {
        Open();
        db.delete(ViagemModel.TABELA_NOME, null, null);
        Close();
    }

    public final ViagemModel CursorToStructure(Cursor ao_cursor) {
        ViagemModel lo_structure = new ViagemModel();

        lo_structure.setId(ao_cursor.getLong(0)); // COLUNA_ID
        lo_structure.setDescricao(ao_cursor.getString(1)); // COLUNA_DESCRICAO
        lo_structure.setTotalKm(ao_cursor.getDouble(2)); // COLUNA_TOTALKM
        lo_structure.setKmPorLitro(ao_cursor.getDouble(3)); // COLUNA_KMLITRO
        lo_structure.setCustoMedioLitro(ao_cursor.getDouble(4)); // COLUNA_CUSTO_MEDIO_LITRO
        lo_structure.setTotalVeiculos(ao_cursor.getInt(5)); // COLUNA_TOTAL_VEICULOS
        lo_structure.setTotalGasolina(ao_cursor.getDouble(6)); // COLUNA_TOTAL_GASONLINA
        lo_structure.setAdicionarGasolina(ao_cursor.getInt(7)); // COLUNA_ADICIONAR_GASOLINA
        lo_structure.setCustoTarifaPessoa(ao_cursor.getDouble(8)); // COLUNA_CUSTO_TARIFA_PESSOA
        lo_structure.setAluguelVeiculo(ao_cursor.getDouble(9)); // COLUNA_ALUGUEL_VEICULO
        lo_structure.setTotalTarifaAerea(ao_cursor.getDouble(10)); // COLUNA_TOTAL_TARIFA_AEREA
        lo_structure.setAdicionarTarifaAerea(ao_cursor.getInt(11)); // COLUNA_ADICIONAR_TARIFA
        lo_structure.setCustoRefeicao(ao_cursor.getDouble(12)); // COLUNA_CUSTO_REFEICAO
        lo_structure.setRefeicoesDia(ao_cursor.getInt(13)); // COLUNA_REFEICOES_DIA
        lo_structure.setTotalRefeicoes(ao_cursor.getDouble(14)); // COLUNA_TOTAL_REFEICOES
        lo_structure.setAdicionarRefeicoes(ao_cursor.getInt(15)); // COLUNA_ADICIONAR_REFEICOES
        lo_structure.setCustoNoite(ao_cursor.getDouble(16)); // COLUNA_CUSTO_NOITE
        lo_structure.setTotalNoites(ao_cursor.getInt(17)); // COLUNA_TOTAL_NOITES
        lo_structure.setTotalQuartos(ao_cursor.getInt(18)); // COLUNA_TOTAL_QUARTOS
        lo_structure.setTotalHospedagem(ao_cursor.getDouble(19));
        lo_structure.setAdicionarHospedagem(ao_cursor.getInt(20)); // COLUNA_ADICIONAR_HOSPEDAGEM
        lo_structure.setIdUsuario(ao_cursor.getInt(21)); // COLUNA_ID_USUARIO
        lo_structure.setTotalViajantes(ao_cursor.getInt(22)); // COLUNA_TOTAL_VIAJANTES
        lo_structure.setDuracaoDias(ao_cursor.getInt(23)); // COLUNA_DURACAO_DIAS

        return lo_structure;
    }

    public void AbrirBanco() throws SQLException {
        Open();
    }
}
