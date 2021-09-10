package com.example.appv6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class registro extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue rq1;
    JsonRequest jrq1;
    EditText usrio, nombre,ap , am ,contra, ccontra, edad;
    RadioButton rd1, rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usrio = (EditText)findViewById(R.id.et_userr);
        nombre = (EditText)findViewById(R.id.et_nombres);
        ap = (EditText)findViewById(R.id.et_ap);
        am = (EditText)findViewById(R.id.et_am);
        contra = (EditText)findViewById(R.id.et_password);
        ccontra = (EditText)findViewById(R.id.et_cpassword);
        edad = (EditText)findViewById(R.id.et_edad);
        rd1 = (RadioButton)findViewById(R.id.radioButton);
        rd2 = (RadioButton)findViewById(R.id.radioButton2);

        rq1 = Volley.newRequestQueue(this);
    }


    public void reg(View view){
        if(TextUtils.isEmpty(usrio.getText()) || TextUtils.isEmpty(nombre.getText()) || TextUtils.isEmpty(ap.getText()) || TextUtils.isEmpty(am.getText()) || TextUtils.isEmpty(contra.getText()) ||
                TextUtils.isEmpty(ccontra.getText()) || TextUtils.isEmpty(edad.getText())) {
            Toast.makeText(this, "Todos los campos deben ser llenados, favor de checar", Toast.LENGTH_SHORT).show();
        } else if(usrio.getText().toString().length() > 10){
            Toast.makeText(this,"Usuario debe tener menos de 10 caracteres", Toast.LENGTH_SHORT).show();
        } else if (!(contra.getText().toString().equals(ccontra.getText().toString()))){
            Toast.makeText(this,"Las contraseñas son diferentes, favor de checar", Toast.LENGTH_SHORT).show();
        } else if (edad.getText().toString().length() > 2){
            Toast.makeText(this,"Edad invalida", Toast.LENGTH_SHORT).show();
        } else {
            registrarusr();
        }
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"Error a registrar el usuario, verifique los valores ingresados e intente de nuevo",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this,"Operacion exitosa, Usuario Registrado",Toast.LENGTH_SHORT).show();
        limpiarcampos();
        Intent isd = new Intent(this, MainActivity.class);
        startActivity(isd);
    }

    void limpiarcampos(){
        usrio.setText("");
        nombre.setText("");
        ap.setText("");
        am.setText("");
        contra.setText("");
        ccontra.setText("");
        edad.setText("");
    }

    private void registrarusr(){
        String st;
        if(rd1.isChecked())
        {
            st = "E";
        } else {
            st = "P";
        }
        String nom = nombre.getText().toString() + " " + ap.getText().toString()+ " " + am.getText().toString();
        String url = "https://nah220.000webhostapp.com/php/regfull.php?user=" + usrio.getText().toString() + "&nombre=" + nom + "&pwd=" + contra.getText().toString()+ "&edad=" + edad.getText().toString()+ "&status=" + st;
        jrq1 = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq1.add(jrq1);
    }
}