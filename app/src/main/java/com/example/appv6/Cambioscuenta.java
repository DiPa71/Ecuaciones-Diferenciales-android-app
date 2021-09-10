package com.example.appv6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Cambioscuenta extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    RequestQueue rq2;
    JsonRequest jrq2;
    String duser;
    EditText userc, nombrec, pswc, edadc, confirmarc, pswc1;
    Button btazl, btred;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambioscuenta);
        userc = (EditText)findViewById(R.id.et_cuser);
        nombrec = (EditText)findViewById(R.id.et_cnombres);
        pswc = (EditText)findViewById(R.id.et_capassword);
        pswc1 = (EditText)findViewById(R.id.et_capassword1);
        edadc = (EditText)findViewById(R.id.et_cedad);
        confirmarc = (EditText)findViewById(R.id.et_confirmarc);

        btazl = (Button)findViewById(R.id.btn_aceptarc);
        btred = (Button)findViewById(R.id.btn_eliminarc);
        rq2 = Volley.newRequestQueue(this);
        RecibirD();
        iniciarcampos();
        btazl.setText("Cambiar datos");
        btred.setText("Eliminar cuenta");
    }


    public void Botonazul(View v){
        if(btazl.getText().equals("Cambiar datos")){
            liberarcampos();
            nombrec.setEnabled(true);
            edadc.setEnabled(true);
            pswc.setVisibility(View.GONE);
            pswc1.setVisibility(View.VISIBLE);
            confirmarc.setVisibility(View.VISIBLE);
            edadc.setInputType(InputType.TYPE_CLASS_NUMBER);
            btazl.setText("Aceptar cambios");
            btred.setText("Cancelar");

        } else if(btazl.getText().equals("Aceptar cambios")){
            if(TextUtils.isEmpty(pswc1.getText()) || TextUtils.isEmpty(nombrec.getText()) || TextUtils.isEmpty(edadc.getText()) || TextUtils.isEmpty(confirmarc.getText())){
                Toast.makeText(this,"Todos los campos deben ser llenados, favor de checar", Toast.LENGTH_SHORT).show();
            } else if(!(pswc1.getText().toString().equals(confirmarc.getText().toString()))){
                Toast.makeText(this,"Las contraseñas son diferentes, favor de checar", Toast.LENGTH_SHORT).show();
            } else if (edadc.getText().toString().length() > 2){
                Toast.makeText(this,"Edad invalida", Toast.LENGTH_SHORT).show();
            } else {
                modificarcampos();
                btazl.setText("Cambiar datos");
                btred.setText("Eliminar cuenta");}

        } else if(btazl.getText().equals("Aceptar Eliminacion")){
            eliminarc();
            Intent intc = new Intent(this, MainActivity.class);
            startActivity(intc);
        }
    }

    public void Botonrojo(View v){
        if(btred.getText().equals("Eliminar cuenta")){
            btazl.setText("Aceptar Eliminacion");
            btred.setText("Cancelar");
        } else if(btred.getText().equals("Cancelar")){
            btazl.setText("Cambiar datos");
            btred.setText("Eliminar cuenta");
            iniciarcampos();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
    }

    @Override
    public void onResponse(JSONObject response) {

        liberarcampos();
        User usuarioc = new User();
        JSONArray jsar2 = response.optJSONArray("datos");
        JSONObject jsobj2 = null;

        try {
            jsobj2 = jsar2.getJSONObject(0);
            usuarioc.setUser(jsobj2.optString("usuario"));
            usuarioc.setNames(jsobj2.optString("nombre"));
            usuarioc.setPwd(jsobj2.optString("paswword"));
            usuarioc.setEdad(jsobj2.optString("edad"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        pswc.setVisibility(View.VISIBLE);
        pswc1.setVisibility(View.GONE);
        edadc.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        userc.setText("Usuario: " + usuarioc.getUser());
        nombrec.setText("Nombre: " + usuarioc.getNames());
        edadc.setText("Edad: " + usuarioc.getEdad() + " años");
        pswc.setText("Contraseña: " + usuarioc.getPwd());
        nombrec.setEnabled(false);
        pswc.setEnabled(false);
        edadc.setEnabled(false);
        confirmarc.setVisibility(View.GONE);
    }

    private void iniciarcampos(){
        String url = "https://nah220.000webhostapp.com/php/cargarv.php?user="+duser;
        jrq2 = new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        rq2.add(jrq2);
    }

    private void modificarcampos(){
        String url = "https://nah220.000webhostapp.com/php/modificar.php?user="+duser + "&nombre=" + nombrec.getText().toString() + "&pwd=" + pswc1.getText().toString() + "&edad=" + edadc.getText().toString();
        jrq2 = new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        rq2.add(jrq2);
    }

    private void eliminarc(){
        String url = "https://nah220.000webhostapp.com/php/eliminar.php?user="+duser;
        jrq2 = new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        rq2.add(jrq2);
    }

    void liberarcampos(){
        nombrec.setText("");
        pswc.setText("");
        pswc1.setText("");
        edadc.setText("");
        confirmarc.setText("");
    }

    private void RecibirD(){
        Bundle ext = getIntent().getExtras();
        duser = ext.getString("duser1");
    }
}
