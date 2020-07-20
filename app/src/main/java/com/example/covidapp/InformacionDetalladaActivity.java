package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InformacionDetalladaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_detallada);
    }
    public void onClickBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void onClickRegionesTotal(View v){
        Intent intent = new Intent(this, TotalRegionesActivity.class);
        startActivity(intent);
        finish();
    }
    public void onClickRegionesDetallada(View v){
        Intent intent = new Intent(this, PorRegionActivity.class);
        startActivity(intent);
        finish();
    }
}
