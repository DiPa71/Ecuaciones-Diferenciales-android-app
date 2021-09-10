package com.example.appv6;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    public static final String nombres = "names";
    public static final String usuraiou = "usur";

    MediaPlayer mp, mp1,mp2,mp3;
    int contadorpika = 0,loboc = 0;
    String Usr, Usr2;
    private AppBarConfiguration mAppBarConfiguration;
    private Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send, R.id.nav_quinta, R.id.nav_sexta)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        Usr2 = getIntent().getStringExtra("usur");
        Usr = getIntent().getStringExtra("names");
        Toast.makeText(this, "!Bienvenido " + Usr + "!", Toast.LENGTH_LONG).show();

        mp = MediaPlayer.create(this, R.raw.pikas);
        mp1 = MediaPlayer.create(this,R.raw.poke);
        mp2 = MediaPlayer.create(this,R.raw.wolf);
        tb = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Opciones del actionbar (Toolbar).
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void masinfolog(View view)
    {
        Intent intent = new Intent(this, loganexos.class);
        intent.putExtra("num",2);
        this.startActivity(intent);
    }
    public void masinfoecuhomo(View view)
    {
        Intent intent = new Intent(this, ecuhomopasos.class);
        intent.putExtra("num",2);
        this.startActivity(intent);
    }
    public void botonmasinfo2(View view)
    {
        Intent intent = new Intent(this, InfoCom1.class);
        intent.putExtra("num",2);
        this.startActivity(intent);
    }
    public void botonmasinfo3(View view)
    {
        Intent intent = new Intent(this, InfoCom1.class);
        intent.putExtra("num",3);
        this.startActivity(intent);
    }
    public void botonmasinfo4(View view)
    {
        Intent intent = new Intent(this, InfoCom1.class);
        intent.putExtra("num",4);
        this.startActivity(intent);
    }
    public void botonmasinfo5(View view)
    {
        Intent intent = new Intent(this, InfoCom1.class);
        intent.putExtra("num",5);
        this.startActivity(intent);
    }
    public void lobo(View view)
    {
        mp2.start();
            Toast.makeText(this,("Team Lobo Alfa Dinamita"), Toast.LENGTH_SHORT).show();
    }

    public void pikachu(View view)
    {
        mp.start();
        contadorpika += 1;
        if(contadorpika >= 5){
        Toast.makeText(this,(contadorpika + "pikachus"), Toast.LENGTH_SHORT).show();
        }
        if (contadorpika >= 10){
            mp1.start();
            contadorpika = 0;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_settings:
                Intent i2 = new Intent(this, Cambioscuenta.class);
                i2.putExtra("duser1", Usr2);
                startActivity(i2);
                return true;
            case R.id.salir:
                Intent i3 = new Intent(this, MainActivity.class);
                startActivity(i3);
                finish();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
    public void pasos(View pasos){
        Intent p2 = new Intent(this, Pasos_solucion.class);
        startActivity(p2);
    }
    public void solu(View soluciones){
        Intent p1 = new Intent(this, Tipossoluciones.class);
        startActivity(p1);
    }

    }

