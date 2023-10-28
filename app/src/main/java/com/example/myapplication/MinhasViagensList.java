package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private ImageButton btnEditar, btnExcluir;
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
        btnExcluir = view.findViewById(R.id.btnExcluir);
        btnAdicionarEntretenimento = view.findViewById(R.id.btnAdicionarEntretenimento);


        if (descricao != null) {
            String item = itemList.get(posicao)[0];
            String id = itemList.get(posicao)[1];
            descricao.setText(item);
            btnEditar.setTag(id);
            btnExcluir.setTag(id);
        }

        btnEditar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                List<ViagemModel> viagem;
                String viagemId = (String) view.getTag();
                {
                    try {
                        viagem = new ViagemDAO(context).retrieve(viagemId);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("MinhasPreferencias", Context.MODE_PRIVATE);
                Intent intent = new Intent(context, UpdateCadastroViagemActivity.class);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putLong("viagem_data", viagem.get(0).getId());

                editor.apply();
                context.startActivity(intent);
            }
        });

        if(btnAdicionarEntretenimento != null ) {
            btnAdicionarEntretenimento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListaEntretenimento.class);
                    context.startActivity(intent);
                }
            });
        }

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String viagemId = (String) view.getTag();
                try {
                    new ViagemDAO(context).Delete(Long.parseLong(viagemId));
                    // Update your itemList by removing the deleted item from the list
                    itemList.remove(posicao);
                    notifyDataSetChanged(); // Notify the adapter that the data set has changed
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return view;

    }
}

