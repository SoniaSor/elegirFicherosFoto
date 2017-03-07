package com.example.sonia.interfazgrafica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class actividad_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
    }//final onCreate

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        //Inflar el menú de la Action Bar:
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
        //El método recibe como parámetro una instancia de tipo Menu, equivalente
        //al elemento XML <menu>
        //Web: http://www.hermosaprogramacion.com/2014/09/android-action-bar/
    }//final onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Asignar las funciones a cada botón.
        switch(item.getItemId()){
            case R.id.op1:
                Log.d("Sonia","Dentro de la opción: Ir a otro menú");
                Toast toast1 = Toast.makeText(getApplicationContext(),"Dentro de la opción: Ir a otro menú",Toast.LENGTH_LONG);
                toast1.show();
                //La opción 1 abre la actividad listaOpciones1
                Intent intencion1 = new Intent (this,listaOpciones1.class);
                startActivity(intencion1);
                return true;
            case R.id.op2:
                Log.d("Sonia","Dentro de la opción: Mostrar una imagen");
                Toast toast2 = Toast.makeText(getApplicationContext(),"Dentro de la opción: Mostrar una imagen",Toast.LENGTH_LONG);
                toast2.show();
                //La opción 2 abre la actividad mostrarImagen3
                Intent intencion2 = new Intent (this,mostrarImagen3.class);
                startActivity(intencion2);
                return true;
            case R.id.op3:
                Log.d("Sonia","Dentro de la opción: Opción de prueba");
                Toast toast3 = Toast.makeText(getApplicationContext(),"Dentro de la opción: Opción de prueba",Toast.LENGTH_LONG);
                toast3.show();
                return true;
        }//final switch
        return true;
    }//final onOptionsItemSelected
}//final class



