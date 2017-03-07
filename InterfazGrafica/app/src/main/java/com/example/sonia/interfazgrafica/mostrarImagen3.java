package com.example.sonia.interfazgrafica;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class mostrarImagen3 extends AppCompatActivity {
    //Fuente = http://trellat.es/seleccionar-una-imagen-de-la-galeria-en-android/

    Button abrir_foto;
    private static final int SELECT_FILE=1; //constante que indica el código del Intent para luego ser capaces de obtener la imagen que devolverá.
    Button fer_foto;
    private static final int FOTO_CAMARA=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_imagen3);
        abrir_foto = (Button) findViewById(R.id.abrir_foto);
        abrir_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Sonia","Se ha pulsado el botón abrir imagen");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Seleccione una imagen"),SELECT_FILE);
            }//final onClick
        });//final setOnClickListener
        fer_foto = (Button) findViewById(R.id.fer_foto);
        fer_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Sonia","Se ha pulsado el botón hacer foto");
                //Creamos el intent para llamar a la camara
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri foto_save = null;
                if (takePictureIntent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(takePictureIntent,FOTO_CAMARA);
                }//final if
            }//final onCLick
        });//final setOnClickListener
    }//final onCreate

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Log.d("Sonia","Estamos dentro del onActivityResult para abrir la imagen");
        Uri selectedImageUri = null;
        Uri selectedImage;
        ImageView foto = (ImageView) findViewById(R.id.foto);
        if(requestCode==SELECT_FILE){
            selectedImage = data.getData();
            Log.d("Sonia", "el nom de la imatge es: " + selectedImage.toString());
            Log.d("Sonia","ara es quan vaig a fer setImageURI");
            foto.setImageURI(selectedImage);
            Log.d("Sonia","ja he mostrat la imatge");
            //Enviar la foto seleccionada: (pag.109 ApuntesPMOV)
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("image/jpeg");
            sendIntent.putExtra(Intent.EXTRA_STREAM, selectedImage);
            Log.d("Sonia","Se va a enviar la foto INTENT SEND");
        }//final if
        if(requestCode==FOTO_CAMARA && resultCode ==RESULT_OK){
            Log.d("Sonia","Estic fent la foto");
            //Web interesant = http://www.tutorialeshtml5.com/2013/12/tutorial-android-utilizar-el-intent-de.html
            //Fuente = https://developer.android.com/training/camera/photobasics.html#TaskPath
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            foto.setImageBitmap(imageBitmap);
        }//final if
    }//final onActivityResult

}//final class