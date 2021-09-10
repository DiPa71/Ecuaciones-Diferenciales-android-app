package com.example.appv6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class MainActivity extends AppCompatActivity implements Response .Listener<JSONObject>, Response.ErrorListener {
    RequestQueue rq;
    Random r = new Random();
    JsonRequest jrq;
    EditText usr, psw;
    ConstraintLayout lyf;
    int numf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usr = (EditText)findViewById(R.id.ed_usr);
        psw = (EditText)findViewById(R.id.ed_psw);
        rq = Volley.newRequestQueue(this);
        lyf = (ConstraintLayout)findViewById(R.id.ly_log);
        numf = r.nextInt(5);
        Elijefondo();
    }
    public void sinse(View login){
        Intent lognoi = new Intent(this, menu.class);
        startActivity(lognoi);
    }
    public void log(View v){
        iniciarsesion();
    }

    public void reg_btn(View a){
        vaciarcampos();
        Intent ola = new Intent(this, registro.class);
        startActivity(ola);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,"Error, intente de nuevo",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {

        User usuario = new User();
        Toast.makeText(this,"Operacion exitosa",Toast.LENGTH_SHORT).show();
        JSONArray jsar = response.optJSONArray("datos");
        JSONObject jsobj = null;

        try {
            jsobj = jsar.getJSONObject(0);
            usuario.setUser(jsobj.optString("usuario"));
            usuario.setNames(jsobj.optString("nombre"));
            usuario.setPwd(jsobj.optString("paswword"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        vaciarcampos();
        Intent intencion = new Intent(this, menu.class);
        intencion.putExtra(menu.usuraiou, usuario.getUser());
        intencion.putExtra(menu.nombres, usuario.getNames());
        startActivity(intencion);

    }

    private void iniciarsesion(){
        String url = "https://nah220.000webhostapp.com/php/login.php?user="+usr.getText().toString()+"&pwd="+psw.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        rq.add(jrq);
    }

    public void bypass(){
        Intent p = new Intent(this, menu.class);
    }

    void vaciarcampos(){
        usr.setText("");
        psw.setText("");
    }

    private void Elijefondo(){
        switch(numf){
            case 0:
                lyf.setBackgroundResource(R.drawable.loginpor);
                break;
            case 1:
                lyf.setBackgroundResource(R.drawable.loginpor1);
                break;
            case 2:
                lyf.setBackgroundResource(R.drawable.loginpor2);
                break;
            case 3:
                lyf.setBackgroundResource(R.drawable.loginpor3);
                break;
            case 4:
                lyf.setBackgroundResource(R.drawable.loginpor4);
                break;

        }
    }



    }


