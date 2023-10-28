package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.CadastroViagemActivity;
import com.example.myapplication.ListaEntretenimento;
import com.example.myapplication.R;
import com.example.myapplication.database.dao.ViagemDAO;
import com.example.myapplication.database.model.ViagemModel;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class MinhasViagensList extends BaseAdapter {
    private List<String[]> itemList;
    private Context context;
    private Button btnAdicionarEntretenimento;
    private ImageButton btnEditar;
    private TextView descricao, idObject;

    public MinhasViagensList(Context context, List<String[]> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int posicao) {
        return itemList.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lista_minha_viagem, viewGroup, false);
        }

        descricao = view.findViewById(R.id.descricao);
        idObject = view.findViewById(R.id.idObject);
        btnEditar = view.findViewById(R.id.btnEditar);
        btnAdicionarEntretenimento = view.findViewById(R.id.btnAdicionarEntretenimento);

        if (descricao != null) {
            String item = itemList.get(posicao)[0];
            String id = itemList.get(posicao)[1];
            descricao.setText(item);
            idObject.setText(id);

        }
        if(btnEditar != null ) {
            btnEditar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    List<ViagemModel> viagem;

                    {
                        try {
                            viagem = new ViagemDAO(context).retrieve(idObject.getText().toString());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Intent intent = new Intent(context, CadastroViagemActivity.class);
                    intent.putExtra("viagemData", (Serializable) viagem.get(0));
                    context.startActivity(intent);
                }
            });
        }

        if(btnAdicionarEntretenimento != null ) {
            btnAdicionarEntretenimento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListaEntretenimento.class);
                    context.startActivity(intent);
                }
            });
        }

        return view;

    }
}

