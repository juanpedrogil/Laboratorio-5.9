package com.example.juanpedrog.laboratorio59;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView lista;
    List<Item> datos=new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=findViewById(R.id.lista);
        //Obtener los contactos
        Cursor mCursor=managedQuery(ContactsContract.Data.CONTENT_URI,null,null,null,null);
        int nombreIndex=mCursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME);
        int numeroIndex=mCursor.getColumnIndex(ContactsContract.Data.DATA1);
        int tiene=mCursor.getColumnIndex(ContactsContract.Data.HAS_PHONE_NUMBER);
        while(mCursor.moveToNext()){
            String nombre=mCursor.getString(nombreIndex);
            String numero=mCursor.getString(numeroIndex);
            int aux=Integer.parseInt(mCursor.getString(tiene));
            if(aux==1) {
                datos.add(new Item(nombre, numero));
            }
        }


        //Asignar el adapter a la lista
        Adapter adapter=new Adapter(datos);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        lista.setLayoutManager(layoutManager);
        lista.setAdapter(adapter);
    }
}
