package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MinhasViagensList extends BaseAdapter {
    private List<String> itemList;
    private Context context;
    private Button button1, button2;
    private TextView textView;

    public MinhasViagensList(Context context, List<String> itemList) {
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

        textView = view.findViewById(R.id.textView);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);

        if (textView != null) {
            String item = itemList.get(posicao);
            textView.setText(item);
        }
        if(button1 != null ) {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, CadastroViagemActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        if(button2 != null ) {
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        return view;

    }
}

