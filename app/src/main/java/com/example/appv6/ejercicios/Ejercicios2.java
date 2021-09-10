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

import com.example.appv6.menu;
import com.example.appv6.R;

import java.util.Random;

public class Ejercicios2 extends AppCompatActivity {

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
        setContentView(R.layout.activity_ejercicios2);
        lawea = findViewById(R.id.layoutejercicios2);
        tvtitulo = findViewById(R.id.tituloejercicios4);
        tvejercicio = findViewById(R.id.ejericiotexto4);
        respuesta = findViewById(R.id.respuestaejercicio4);
        RG1 = findViewById(R.id.radioGroupres4);
        rba = findViewById(R.id.respuestaA4);
        rbb = findViewById(R.id.respuestaB4);
        rbc = findViewById(R.id.respuestaC4);
        rbd = findViewById(R.id.respuestaD4);
        imgejercicio = findViewById(R.id.imagendeejercicio4);
        btr1 = findViewById(R.id.bottonres14);
        btr2 = findViewById(R.id.bottonres24);
        btr2.setVisibility(View.GONE);
        tvtitulo.setText("Ejercicio De Solucion General y particular");
        btr1.setText("Responder");

        selectordeejercicios();
    }

    public void btn1r(View v){
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

    public void btn2r(View v){
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
        int v1, v2, v3, v4, rg;
        switch(nume){
            case 0:
                opc = 0;
                rg = r.nextInt(4) + 1;
                tvejercicio.setText("Dada la siguiente ecuacion diferencial obtener su solucion general: y'y = x");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "y = x + c";
                if(rg == 1){rba.setText(verres); } else {rba.setText("y = y + c");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("y = y + x");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("y = y'");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("y = x + c'");}
                break;
            case 1:
                opc = 0;
                rg = r.nextInt(4) + 1;
                tvejercicio.setText("Dada la siguiente ecuacion diferencial obtener su solucion general: y' + (sen x)y = 0");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "y = e ^ (cosx + c)";
                if(rg == 1){rba.setText(verres); } else {rba.setText("y = e * (cosx + c)");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("y = e ^ (cosy + c)");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("y = e * (cosy + c)");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("y = e ^ (senx + c)");}
                break;
            case 2:
                opc = 0;
                v1 = r.nextInt(7) + 2;  v2 = (r.nextInt(10) + 1) * 3; v3 = (r.nextInt(10) + 1) * 2; rg = r.nextInt(4) + 1;
                tvejercicio.setText("Dada la siguiente ecuacion diferencial obtener su solucion general: y' - " + v2 + "x² + "+ v3 +"x -" + v1 + " = 0");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "y = " + (v2/3) + "x³ - "+ (v3/2) +"x² + " + v1 + "x + c";
                if(rg == 1){rba.setText(verres); } else {rba.setText("y = " + (v2/3) + "x³ - "+ (v3/2) +"x² - " + v1 + "x - c");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("y = " + (v2/3) + "x³ + "+ (v3/2) +"x² + " + v1 + "x + c");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("y = " + (v2/3) + "x³ + "+ (v3/2) +"x² - " + v1 + "x - c");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("y = " + (v2/3) + "x³ - "+ (v3/2) +"x² - " + v1 + "x + c");}
                break;
            case 3:
                opc = 0;
                v1 = (r.nextInt(10) + 2) * 2; rg = r.nextInt(4) + 1;
                tvejercicio.setText("Dada la siguiente ecuacion diferencial obtener su solucion general: y' - " + v1 + "xy = 0");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "y = e ^ (" + (v1/2) + "x² + c)";
                if(rg == 1){rba.setText(verres); } else {rba.setText("y = " + (v1/2) + "x² + c");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("y = e ^ (2x² + c)");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("y = e ^ (" + (v1/2) + "x²)");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("y = e ^ c");}
                break;
            case 4:
                opc = 0;
                v1 = (r.nextInt(10) + 2) * 3; rg = r.nextInt(4) + 1;
                tvejercicio.setText("Dada la siguiente ecuacion diferencial obtener su solucion general: y' - " + v1 + "x²y = 0");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "y = e ^ (" + (v1/3) + "x³ + c)";
                if(rg == 1){rba.setText(verres); } else {rba.setText("y = " + (v1/3) + "x³ + c");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("y = e ^ (x³/3 + c)");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("y = e ^ (" + (v1/3) + "x³)");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("y = 0");}
                break;
            case 5:
                opc = 0;
                v1 = (r.nextInt(10) + 1) * 2; v2 = r.nextInt(10) + 1; rg = r.nextInt(4) + 1;
                tvejercicio.setText("Dada la siguiente ecuacion diferencial obtener su solucion general: y' - " + v1 + "x + "+ v2 +" = 0");
                respuesta.setVisibility(View.GONE);
                RG1.setVisibility(View.VISIBLE);
                verres = "y = " + (v1/2) + "x² - "+ v2 +"x + c";
                if(rg == 1){rba.setText(verres); } else {rba.setText("y = " + (v1/2) + "x²");}
                if(rg == 2){rbb.setText(verres); } else {rbb.setText("y = " + (v1/2) + "x² - "+ v2 +"x");}
                if(rg == 3){rbc.setText(verres); } else {rbc.setText("y = " + (v1/2) + "x³ - "+ v2 +"x + c");}
                if(rg == 4){rbd.setText(verres); } else {rbd.setText("y = " + v1 + "x² - "+ v2 +"x + c");}
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
