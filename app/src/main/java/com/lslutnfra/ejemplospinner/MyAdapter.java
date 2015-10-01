package com.lslutnfra.ejemplospinner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ernesto on 23/09/15.
 */
public class MyAdapter extends RecyclerView.Adapter{

    private final MainActivity context;
    private ArrayList<Persona> lista;

    public MyAdapter(MainActivity context, ArrayList<Persona> lista){
        this.lista =lista;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new MyViewHolder(context, v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Persona p = lista.get(position);

        MyViewHolder mvh = (MyViewHolder) viewHolder;
        mvh.mNombre.setText(p.getNombre());
        mvh.mApellido.setText(p.getApellido());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
