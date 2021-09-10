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

public class Ejercicios1 extends AppCompatActivity {
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
        setContentView(R.layout.activity_ejercicios1);
        lawea = findViewById(R.id.layoutejercicios5);
        tvtitulo = findViewById(R.id.tituloejercicios5);
        tvejercicio = findViewById(R.id.ejericiotexto5);
        respuesta = findViewById(R.id.respuestaejercicio5);
        RG1 = findViewById(R.id.radioGroupres5);
        rba = findViewById(R.id.respuestaA5);
        rbb = findViewById(R.id.respuestaB5);
        rbc = findViewById(R.id.respuestaC5);
        rbd = findViewById(R.id.respuestaD5);
        imgejercicio = findViewById(R.id.imagendeejercicio5);
        btr1 = findViewById(R.id.bottonres15);
        btr2 = findViewById(R.id.bottonres25);
        btr2.setVisibility(View.GONE);
        tvtitulo.setText("Ejercicio De Orden y Grado");
        btr1.setText("Responder");

        selectordeejercicios();
    }

    public void btn1r1(View v){
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

    public void btn2r1(View v){
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
                rg = r.nextInt(4) + 1;
                tvejercicio.setText("Definir el ORDEN de la ecuacion dy / dx + P(x)y = Q(x)");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "Primer Orden";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Quinto Orden");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Segundo Orden");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("Tercer Orden");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("Cuarto Orden");}
                break;
            case 1:
                opc = 0;
                rg = r.nextInt(4) + 1;
                tvejercicio.setText("Definir el Grado de la ecuacion dy / dx + P(x)y = Q(x)");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "Primer Grado";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Quinto Orden");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Segundo Orden");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("Tercer Orden");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("Cuarto Orden");}
                break;
            case 2:
                opc = 0;
                rg = r.nextInt(4) + 1;
                tvejercicio.setText("Defina el GRADO de la ecuacion e^x d^2 y / dx^2 + senx dy / dx = x");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "Primer Grado";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Quinto Orden");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Segundo Orden");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("Tercer Orden");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("Cuarto Orden");}
                break;
            case 3:
                opc = 0;
                rg = r.nextInt(4) + 1;
                tvejercicio.setText("Defina el ORDEN de la ecuacion e^x d^2 y / dx^2 + senx dy / dx = x");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "Segundo Orden";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Primer Orden");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Quinto Orden");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("Tercer Orden");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("Cuarto Orden");}
                break;
            case 4:
                opc = 0;
                rg = r.nextInt(4) + 1;
                tvejercicio.setText("Defina el ORDEN de la ecuacion d^3 y / dx^3 + 2(d^2 y / dx^2) + dy / dx");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "Tercer Orden";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Primer Orden");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Segundo Orden");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("Quinto Orden");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("Cuarto Orden");}
                break;
            case 5:
                opc = 0;
                rg = r.nextInt(4) + 1;
                tvejercicio.setText("Defina el GRADO de la ecuacion d^3 y / dx^3 + 2(d^2 y / dx^2) + dy / dx");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "Primer Grado";
                if(rg == 1){rba.setText(verres); } else {rba.setText("Quinto Orden");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("Segundo Orden");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("Tercer Orden");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("Cuarto Orden");}
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