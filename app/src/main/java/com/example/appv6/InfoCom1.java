package com.example.appv6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appv6.ejercicios.Ejercicios1;
import com.example.appv6.ejercicios.Ejercicios2;
import com.example.appv6.ejercicios.Ejercicios3;
import com.example.appv6.ejercicios.Ejercicios4;

public class InfoCom1 extends AppCompatActivity {

    int NumA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_com1);
        RecibirD();
        tosty();
    }
    public void botoninfodetallada1(View view)
    {
        Intent intent = new Intent(this, info_detallada.class);
        intent.putExtra("Act_vid",NumA);
        startActivity(intent);
        finish();
    }

    public void botonEjercicios(View view)
    {
        if(NumA == 2){
            Intent intent = new Intent(this, Ejercicios1.class);
            intent.putExtra("Act_ejercicio","orden y grado");
            startActivity(intent);
            finish();
        } else if(NumA == 3){
            Intent intent = new Intent(this, Ejercicios2.class);
            intent.putExtra("Act_ejercicio","Solucion General y particular");
            startActivity(intent);
            finish();
        }else if(NumA == 4){
            Intent intent = new Intent(this, Ejercicios3.class);
            intent.putExtra("Act_ejercicio","Determinar si es una funcion");
            startActivity(intent);
            finish();
        }else if(NumA == 5){
            Intent intent = new Intent(this, Ejercicios4.class);
            intent.putExtra("Act_ejercicio","Tema5");
            startActivity(intent);
            finish();
        }
    }


    private void RecibirD(){
        Bundle ext = getIntent().getExtras();
        NumA = ext.getInt("num");
    }
    private void tosty(){
        if(NumA == 2){
            Toast.makeText(this,"orden y grado",Toast.LENGTH_SHORT).show();
        } else if(NumA == 3){
            Toast.makeText(this,"Solucion General y particular",Toast.LENGTH_SHORT).show();
        }else if(NumA == 4){
            Toast.makeText(this,"Determinar si es una funcion",Toast.LENGTH_SHORT).show();
        }else if(NumA == 5){
            Toast.makeText(this,"Tema5",Toast.LENGTH_SHORT).show();
        }
    }
}
