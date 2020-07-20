package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
    public void onClickGeneral(View v){
        Intent intent = new Intent(this, InformacionGeneralActivity.class);
        startActivity(intent);
        finish();
    }
    public void onClickDetallada(View v){
        Intent intent = new Intent(this, InformacionDetalladaActivity.class);
        startActivity(intent);
        finish();
    }

}
