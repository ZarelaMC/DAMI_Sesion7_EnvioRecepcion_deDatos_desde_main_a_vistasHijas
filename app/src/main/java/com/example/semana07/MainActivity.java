package com.example.semana07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Declarar elementos que se van usar en el Layout
    Spinner spnSelector;

    String [] arregloFrases = {"La seguridad de saberme capaz para algo mejor, me puso en las manos la postergación, que al fin de cuentas es un arma terrible y suicida",
                                "En ciertos oasis el desierto es sólo un espejismo",
                                "La realidad es un manojo de problemas sobre los cuales nadie reclama derechos de autor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Vincular los elementos declarados con los elementos creados en el Layout
        spnSelector = findViewById(R.id.spnSelector);

        //Asignarle evento al Spinner
        spnSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Mostrar layout según opción del Spinner seleccionada
                switch (position){
                    case 1: //Layout Orange
                        Intent intent1 = new Intent(MainActivity.this, OrangeActivity.class);
                        //Mostrar datos del Arrayde frases
                        intent1.putExtra("DATA_FRASE_CELEBRE", arregloFrases[0]);
                        //Ejecutar la vista correspondiente
                        startActivity(intent1);
                        break;
                    case 2://Layout Blue
                        Intent intent2 = new Intent(MainActivity.this, BlueActivity.class);
                        //Mostrar datos del Arrayde frases
                        intent2.putExtra("DATA_FRASE_CELEBRE", arregloFrases[1]);
                        //Ejecutar la vista correspondiente
                        startActivity(intent2);
                        break;
                    case 3://Layout Green
                        Intent intent3 = new Intent(MainActivity.this, GreenActivity.class);
                        //Mostrar datos del Arrayde frases
                        intent3.putExtra("DATA_FRASE_CELEBRE", arregloFrases[0]);
                        //Ejecutar la vista correspondiente
                        startActivity(intent3);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //Métodos para mostrar mensajes
    public void mensajeAlert(String titulo, String msg){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(msg);
        alertDialog.setTitle(titulo);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    public void mensajeAlert(String msg){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(msg);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    void mensajeToast(String mensaje){
        Toast toast1 =  Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG);
        toast1.show();
    }
}