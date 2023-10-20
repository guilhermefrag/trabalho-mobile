package com.example.myapplication.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import com.example.myapplication.database.model.ViagemModel;
public class GasolinaAdapter extends BaseAdapter {
    private Activity activity;
    private List<ViagemModel> listaGasolina;

    public GasolinaAdapter(final Activity activity, final List<ViagemModel> listaGasolina){
        this.activity = activity;
        this.listaGasolina = listaGasolina;
    }
    @Override
    public int getCount() {
        return listaGasolina.size();
    }

    @Override
    public Object getItem(int i) {
        return listaGasolina.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
