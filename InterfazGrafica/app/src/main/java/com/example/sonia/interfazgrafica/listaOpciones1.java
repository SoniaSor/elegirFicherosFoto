package com.example.sonia.interfazgrafica;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

//DUDA => no puedo mostrar el diálogo
public class listaOpciones1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_opciones1);

//CREAR UN DIÁLOGO:
        AlertDialog.Builder builder = new AlertDialog.Builder(this); //crear un constructor de alertas
        builder.setMessage("¿Quieres acceder a la opción?"); //configurar la alerta del mensaje
        builder.setCancelable(false); //no cancelable
        //Texto y acción del botón positivo
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast2 = Toast.makeText(getApplicationContext(),"Elige una opción del spinner",Toast.LENGTH_LONG);
                toast2.show();
            }//final onClick
        });
        //Texto y acción del botón negativo
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }//final onClick
        });
        //Creamos el objeto Alerta
        final AlertDialog alert = builder.create();

//Lista de opciones creada mediante spinner
        Spinner spinner = (Spinner) findViewById (R.id.spinner);
        String[] valores = {"Opción 1","Opción 2","Opción 3","Opción 4","Opción 5"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Sonia","Se ha pulsado una opción del spinner");
//DUDA => no puedo mostrar el diálogo
                alert.show();

            }//final onItemSelected

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //vacio
            }
        });//final setOnItemSelectedListener
    }//final onCreate
}//final listaOpciones1
