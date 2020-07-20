package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TotalRegionesActivity extends AppCompatActivity {
    private Servicio servicio;
    BarChart barChart;
    BarChart barChart2;
    BarChart barChart3;
    BarChart barChart4;
    BarChart barChart5;
    BarChart barChart6;
    BarChart barChart7;

    private Reporte[] reporte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_regiones);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://covid.unnamed-chile.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servicio=retrofit.create(Servicio.class);
        Call<RespuestaRegionesWS> resp= servicio.regionesTotal();
        resp.enqueue(new Callback<RespuestaRegionesWS>() {
            @Override
            public void onResponse(Call<RespuestaRegionesWS> call, Response<RespuestaRegionesWS> response) {
                if(response.isSuccessful()){

                    barChart = (BarChart) findViewById(R.id.bargraph1);
                    barChart2 = (BarChart) findViewById(R.id.bargraph2);
                    barChart3 = (BarChart) findViewById(R.id.bargraph3);
                    barChart4 = (BarChart) findViewById(R.id.bargraph4);
                    barChart5 = (BarChart) findViewById(R.id.bargraph5);
                    barChart6 = (BarChart) findViewById(R.id.bargraph6);
                    barChart7 = (BarChart) findViewById(R.id.bargraph7);

                    ArrayList<BarEntry> barEntries = new ArrayList<>();
                    ArrayList<BarEntry> barEntries2 = new ArrayList<>();
                    ArrayList<BarEntry> barEntries3 = new ArrayList<>();
                    ArrayList<BarEntry> barEntries4 = new ArrayList<>();
                    ArrayList<BarEntry> barEntries5 = new ArrayList<>();
                    ArrayList<BarEntry> barEntries6 = new ArrayList<>();
                    ArrayList<BarEntry> barEntries7 = new ArrayList<>();
                    reporte=response.body().getReporte();
                    for (int i = 0; i < response.body().getReporte().length; i++) {
                        int valor1 = reporte[i].getAcumulado_total();
                        barEntries.add(new BarEntry(valor1, i));
                        int valor2 = reporte[i].getCasos_activos_confirmados();
                        barEntries2.add(new BarEntry(valor2, i));
                        int valor3 = reporte[i].getCasos_nuevos_csintomas();
                        barEntries3.add(new BarEntry(valor3, i));
                        int valor4 = reporte[i].getCasos_nuevos_snotificar();
                        barEntries4.add(new BarEntry(valor4, i));
                        int valor5 = reporte[i].getCasos_nuevos_ssintomas();
                        barEntries5.add(new BarEntry(valor5, i));
                        int valor6 = reporte[i].getCasos_nuevos_total();
                        barEntries6.add(new BarEntry(valor6, i));
                        int valor7 = reporte[i].getFallecidos();
                        barEntries7.add(new BarEntry(valor7, i));
                    }

                    BarDataSet barDataSet = new BarDataSet(barEntries,"Acumulado total");
                    BarDataSet barDataSet2 = new BarDataSet(barEntries2,"Casos Activos confirmados");
                    BarDataSet barDataSet3 = new BarDataSet(barEntries3,"Casos nuevos con sintomas");
                    BarDataSet barDataSet4 = new BarDataSet(barEntries4,"Casos nuevos sin notificar");
                    BarDataSet barDataSet5 = new BarDataSet(barEntries5,"Casos nuevos sin sintomas");
                    BarDataSet barDataSet6 = new BarDataSet(barEntries6,"Casos nuevos total");
                    BarDataSet barDataSet7 = new BarDataSet(barEntries7,"Fallecidos");

                    ArrayList<String> theDates = new ArrayList<>();
                    ArrayList<String> theDates2 = new ArrayList<>();
                    ArrayList<String> theDates3 = new ArrayList<>();
                    ArrayList<String> theDates4 = new ArrayList<>();
                    ArrayList<String> theDates5 = new ArrayList<>();
                    ArrayList<String> theDates6 = new ArrayList<>();
                    ArrayList<String> theDates7 = new ArrayList<>();
                    theDates.add("Arica");
                    theDates.add("Tarapaca");
                    theDates.add("Antofagasta");
                    theDates.add("Atacama");
                    theDates.add("Coquimbo");
                    theDates.add("Valparaiso");
                    theDates.add("Metropolitana");
                    theDates.add("O'Higgins");
                    theDates.add("Maule");
                    theDates.add("Ñuble");
                    theDates.add("Biobio");
                    theDates.add("Araucania");
                    theDates.add("Los Rios");
                    theDates.add("Los Lagos");
                    theDates.add("Aysen");
                    theDates.add("Magallanes");

                    theDates2.add("Arica");
                    theDates2.add("Tarapaca");
                    theDates2.add("Antofagasta");
                    theDates2.add("Atacama");
                    theDates2.add("Coquimbo");
                    theDates2.add("Valparaiso");
                    theDates2.add("Metropolitana");
                    theDates2.add("O'Higgins");
                    theDates2.add("Maule");
                    theDates2.add("Ñuble");
                    theDates2.add("Biobio");
                    theDates2.add("Araucania");
                    theDates2.add("Los Rios");
                    theDates2.add("Los Lagos");
                    theDates2.add("Aysen");
                    theDates2.add("Magallanes");

                    theDates3.add("Arica");
                    theDates3.add("Tarapaca");
                    theDates3.add("Antofagasta");
                    theDates3.add("Atacama");
                    theDates3.add("Coquimbo");
                    theDates3.add("Valparaiso");
                    theDates3.add("Metropolitana");
                    theDates3.add("O'Higgins");
                    theDates3.add("Maule");
                    theDates3.add("Ñuble");
                    theDates3.add("Biobio");
                    theDates3.add("Araucania");
                    theDates3.add("Los Rios");
                    theDates3.add("Los Lagos");
                    theDates3.add("Aysen");
                    theDates3.add("Magallanes");

                    theDates4.add("Arica");
                    theDates4.add("Tarapaca");
                    theDates4.add("Antofagasta");
                    theDates4.add("Atacama");
                    theDates4.add("Coquimbo");
                    theDates4.add("Valparaiso");
                    theDates4.add("Metropolitana");
                    theDates4.add("O'Higgins");
                    theDates4.add("Maule");
                    theDates4.add("Ñuble");
                    theDates4.add("Biobio");
                    theDates4.add("Araucania");
                    theDates4.add("Los Rios");
                    theDates4.add("Los Lagos");
                    theDates4.add("Aysen");
                    theDates4.add("Magallanes");

                    theDates5.add("Arica");
                    theDates5.add("Tarapaca");
                    theDates5.add("Antofagasta");
                    theDates5.add("Atacama");
                    theDates5.add("Coquimbo");
                    theDates5.add("Valparaiso");
                    theDates5.add("Metropolitana");
                    theDates5.add("O'Higgins");
                    theDates5.add("Maule");
                    theDates5.add("Ñuble");
                    theDates5.add("Biobio");
                    theDates5.add("Araucania");
                    theDates5.add("Los Rios");
                    theDates5.add("Los Lagos");
                    theDates5.add("Aysen");
                    theDates5.add("Magallanes");

                    theDates6.add("Arica");
                    theDates6.add("Tarapaca");
                    theDates6.add("Antofagasta");
                    theDates6.add("Atacama");
                    theDates6.add("Coquimbo");
                    theDates6.add("Valparaiso");
                    theDates6.add("Metropolitana");
                    theDates6.add("O'Higgins");
                    theDates6.add("Maule");
                    theDates6.add("Ñuble");
                    theDates6.add("Biobio");
                    theDates6.add("Araucania");
                    theDates6.add("Los Rios");
                    theDates6.add("Los Lagos");
                    theDates6.add("Aysen");
                    theDates6.add("Magallanes");

                    theDates7.add("Arica");
                    theDates7.add("Tarapaca");
                    theDates7.add("Antofagasta");
                    theDates7.add("Atacama");
                    theDates7.add("Coquimbo");
                    theDates7.add("Valparaiso");
                    theDates7.add("Metropolitana");
                    theDates7.add("O'Higgins");
                    theDates7.add("Maule");
                    theDates7.add("Ñuble");
                    theDates7.add("Biobio");
                    theDates7.add("Araucania");
                    theDates7.add("Los Rios");
                    theDates7.add("Los Lagos");
                    theDates7.add("Aysen");
                    theDates7.add("Magallanes");




                    BarData theData = new BarData(theDates,barDataSet);
                    BarData theData2 = new BarData(theDates2,barDataSet2);
                    BarData theData3 = new BarData(theDates3,barDataSet3);
                    BarData theData4 = new BarData(theDates4,barDataSet4);
                    BarData theData5 = new BarData(theDates5,barDataSet5);
                    BarData theData6 = new BarData(theDates6,barDataSet6);
                    BarData theData7 = new BarData(theDates7,barDataSet7);
                    barChart.setData(theData);
                    barChart2.setData(theData2);
                    barChart3.setData(theData3);
                    barChart4.setData(theData4);
                    barChart5.setData(theData5);
                    barChart6.setData(theData6);
                    barChart7.setData(theData7);

                    barChart.setTouchEnabled(true);
                    barChart.setDragEnabled(true);
                    barChart.setScaleEnabled(true);

                    barChart2.setTouchEnabled(true);
                    barChart2.setDragEnabled(true);
                    barChart2.setScaleEnabled(true);
                    barChart3.setTouchEnabled(true);
                    barChart3.setDragEnabled(true);
                    barChart3.setScaleEnabled(true);
                    barChart4.setTouchEnabled(true);
                    barChart4.setDragEnabled(true);
                    barChart4.setScaleEnabled(true);
                    barChart5.setTouchEnabled(true);
                    barChart5.setDragEnabled(true);
                    barChart5.setScaleEnabled(true);
                    barChart6.setTouchEnabled(true);
                    barChart6.setDragEnabled(true);
                    barChart6.setScaleEnabled(true);
                    barChart7.setTouchEnabled(true);
                    barChart7.setDragEnabled(true);
                    barChart7.setScaleEnabled(true);
                }
            }
            @Override
            public void onFailure(Call<RespuestaRegionesWS> call, Throwable t) {

            }
        });


    }
    public void onClickBack(View v){
        Intent intent = new Intent(this, InformacionDetalladaActivity.class);
        startActivity(intent);
        finish();
    }


}
