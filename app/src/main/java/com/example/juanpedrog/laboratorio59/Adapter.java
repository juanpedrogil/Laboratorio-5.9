package com.example.juanpedrog.laboratorio59;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ListaViewHolder>{
    List<Item> datos;

    public Adapter(List<Item> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ListaViewHolder listaViewHolder=new ListaViewHolder(v);
        return listaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        holder.nombre.setText(datos.get(position).getNombre());
        holder.numero.setText(datos.get(position).getNumero());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,numero;
        public ListaViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            numero=itemView.findViewById(R.id.numero);
        }
    }
}
