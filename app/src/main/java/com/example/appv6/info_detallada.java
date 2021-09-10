package com.example.appv6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class info_detallada extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    int numv;
    YouTubePlayerView youTubePlayerView;
    String claveYoutube="AIzaSyBR3sZusyjWYjsTYOr6cHVGmS4-NskpwjA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_detallada);
        RecibirD();
        tosty();
        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.elyutubi);
        reproduceelvidio();
    }
    private void RecibirD(){
        Bundle ext = getIntent().getExtras();
        numv = ext.getInt("Act_vid");
    }

    private void tosty() {
        if (numv == 2) {
            Toast.makeText(this, "orden y grado", Toast.LENGTH_SHORT).show();
        } else if (numv == 3) {
            Toast.makeText(this, "Solucion General y particular", Toast.LENGTH_SHORT).show();
        } else if (numv == 4) {
            Toast.makeText(this, "Determinar si es una funcion", Toast.LENGTH_SHORT).show();
        } else if (numv == 5) {
            Toast.makeText(this, "Tema5", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fuerestaurado) {
        if(fuerestaurado)
        {
            youTubePlayer.cueVideo("W03EIyBCOPI");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
if(youTubeInitializationResult.isUserRecoverableError()){

    youTubeInitializationResult.getErrorDialog(this,1).show();
}else {
    String error ="Error al inicializar la inicializacion"+youTubeInitializationResult.toString();
    Toast.makeText(getApplication(),error,Toast.LENGTH_LONG).show();
}
    }
    protected void onActivityResult(int requestCode, int resultcode, Intent data){
        if(resultcode==1){
            //getYoutubePlayer().initialize(claveYoutube,this);
        }
    }
    protected YouTubePlayer.Provider getYoutubePlayer(){
        return youTubePlayerView;
    }

    private void reproduceelvidio(){
        youTubePlayerView.initialize(claveYoutube,this);
    }
}
