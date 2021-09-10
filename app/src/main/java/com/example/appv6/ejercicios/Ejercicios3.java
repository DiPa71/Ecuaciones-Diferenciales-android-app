package com.example.appv6.ejercicios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.appv6.R;
import com.example.appv6.menu;

import java.util.Random;

public class Ejercicios3 extends AppCompatActivity {

    Random r = new Random();
    ConstraintLayout lawea;
    TextView tvtitulo, tvejercicio;
    EditText respuesta;
    RadioGroup RG1;
    RadioButton rba, rbb, rbc, rbd;
    ImageView imgejercicio;
    Button btr1, btr2;
    int nume, cont, conb , opc;
    String verres, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios3);
        lawea = findViewById(R.id.layoutejercicios3);
        tvtitulo = findViewById(R.id.tituloejercicios4);
        tvejercicio = findViewById(R.id.ejericiotexto4);
        respuesta = findViewById(R.id.respuestaejercicio4);
        RG1 = findViewById(R.id.radioGroupres3);
        rba = findViewById(R.id.respuestaA4);
        rbb = findViewById(R.id.respuestaB4);
        rbc = findViewById(R.id.respuestaC4);
        rbd = findViewById(R.id.respuestaD4);
        imgejercicio = findViewById(R.id.imagendeejercicio3);
        btr1 = findViewById(R.id.bottonres14);
        btr2 = findViewById(R.id.bottonres24);
        btr2.setVisibility(View.GONE);
        tvtitulo.setText("Ejercicio De Solucion General y particular");
        btr1.setText("Responder");

        selectordeejercicios();
    }
    public void btn1r3(View v){
        if(btr1.getText().toString().equals("Responder")){
            if(opc == 0){
                radiogropus();
                verificar();
            }else if (opc == 1){
                res = respuesta.getText().toString();
                verificar();
            }

            btr1.setText("Siguiente Pregunta");
            btr2.setText("Resultados");
            btr2.setVisibility(View.VISIBLE);
            cont = cont + 1;
        } else if(btr1.getText().toString().equals("Siguiente Pregunta")){
            lawea.setBackgroundResource(R.drawable.ejerciciosimagen);
            tvtitulo.setText("Ejercicio De Solucion General y particular");
            btr1.setText("Responder");
            btr2.setVisibility(View.GONE);

            selectordeejercicios();
            limpiarcampo();
        } else if(btr1.getText().toString().equals("Continuar")){
            cont = 0; conb = 0;
            lawea.setBackgroundResource(R.drawable.ejerciciosimagen);
            tvtitulo.setText("Ejercicio De Solucion General y particular");
            btr1.setText("Responder");
            btr2.setVisibility(View.GONE);

            selectordeejercicios();
            limpiarcampo();
        }
    }

    public void btn2r3(View v){
        if(btr2.getText().toString().equals("Resultados")){
            tvtitulo.setText("Ejercicio De Solucion General y particular");
            tvejercicio.setText("tu resultados fueron: " + conb + "/" + cont);
            btr1.setText("Continuar");
            btr2.setText("Salir");
        }else if(btr2.getText().toString().equals("Salir")){
            Intent i = new Intent(this, menu.class);
            startActivity(i);
            finish();
        }
    }

    private void selectordeejercicios(){
        nume = r.nextInt(6);
        int rg;
        switch(nume){
            case 0:
                opc = 0;
                rg = r.nextInt(2) + 1;
                tvejercicio.setText("Dada la funcion y=asen(x) ¿es una solucion para y'' + y = 0?");
                respuesta.setVisibility(View.GONE);
                rbc.setVisibility(View.GONE);
                rbd.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres="Verdadero";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Falso");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Falso");}
                break;
            case 1:
                opc = 0;
                rg = r.nextInt(2) + 1;
                tvejercicio.setText("Dada la fucion f(x) = e^2x + e^x, ¿es solucion de y''=-4y'+4y=e^x");
                respuesta.setVisibility(View.GONE);
                rbc.setVisibility(View.GONE);
                rbd.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres="Verdadero";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Falso");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Falso");}
                break;
            case 2:
                opc = 0;
                rg = r.nextInt(2) + 1;
                tvejercicio.setText("La funcion f(x)= xe^2x + e^x ¿Es solucion de y''=-4y + 4y = e^x");
                respuesta.setVisibility(View.GONE);
                rbc.setVisibility(View.GONE);
                rbd.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres="Verdadero";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Falso");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Falso");}
                break;
            case 3:
                opc = 0;
                rg = r.nextInt(2) + 1;
                tvejercicio.setText("La funcion f(x)= 2e^-x +xe^x ¿Es solucion de y''+2y' + y = 0");
                respuesta.setVisibility(View.GONE);
                rbc.setVisibility(View.GONE);
                rbd.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres="Verdadero";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Falso");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Falso");}
                break;
            case 4:
                opc = 0;
                rg = r.nextInt(2) + 1;
                tvejercicio.setText("La funcion f(x)=5e^-2x ¿Es solucion general de y'+2y = 0");
                respuesta.setVisibility(View.GONE);
                rbc.setVisibility(View.GONE);
                rbd.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres="Verdadero";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Falso");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Falso");}
                break;
            case 5:
                opc = 0;
                rg = r.nextInt(2) + 1;
                tvejercicio.setText("La funcion f(x)=1/9t +sen(3t) ¿Es solucion general de y'' + 9y = t");
                respuesta.setVisibility(View.GONE);
                rbc.setVisibility(View.GONE);
                rbd.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres="Verdadero";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Falso");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Falso");}
                break;
            case 6:
                opc = 0;
                rg = r.nextInt(2) + 1;
                tvejercicio.setText("La funcion bcos(x) ¿Es solucion de y'' + y = 0");
                respuesta.setVisibility(View.GONE);
                rbc.setVisibility(View.GONE);
                rbd.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres="Verdadero";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Falso");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Falso");}
                break;
        }

    }

    private void verificar(){
        if(verres.equals(res)){
            lawea.setBackgroundResource(R.drawable.ejerciciosbien);
            conb = conb + 1;
            RG1.setVisibility(View.GONE);
            respuesta.setVisibility(View.GONE);
            tvtitulo.setText("Respuesta Correcta");
        } else{
            lawea.setBackgroundResource(R.drawable.ejerciciosmal);
            RG1.setVisibility(View.GONE);
            respuesta.setVisibility(View.GONE);
            tvejercicio.setText("la respuesta correcta era: " + verres);
            tvtitulo.setText("Respuesta incorrecta");
        }
    }

    private void radiogropus(){
        if (rba.isChecked()){
            res = rba.getText().toString();
        } else if (rbb.isChecked()){
            res = rbb.getText().toString();
        } else if (rbc.isChecked()){
            res = rbc.getText().toString();
        } else if (rbd.isChecked()){
            res = rbd.getText().toString();
        }
    }

    private void limpiarcampo(){
        RG1.clearCheck();
        respuesta.setText("");
    }
}
