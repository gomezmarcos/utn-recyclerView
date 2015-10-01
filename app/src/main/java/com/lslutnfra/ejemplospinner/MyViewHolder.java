package com.lslutnfra.ejemplospinner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by ernesto on 23/09/15.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    private MainActivity context;
    public TextView mNombre;
    public TextView mApellido;
    public int position;

    public MyViewHolder(final MainActivity context, final View itemView) {
        super(itemView);

        mNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        mApellido = (TextView) itemView.findViewById(R.id.txtApellido);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mNombre.getText(), Toast.LENGTH_SHORT).show();
                context.metodoLoco(position);
            }
        });
    }
}
