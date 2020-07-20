package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
/*
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
 */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InformacionGeneralActivity extends AppCompatActivity {
    private TextView texto1,texto2,texto3,texto4,texto5,texto6,texto7,texto8;
    private Servicio servicio;

    //private RelativeLayout mainLayout;
    //private PieChart mChart;
    //private float[] yData = {5,10,15,30,40};
    //private String[] xData= {"arr","barr","carr","darr","earr"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_general);
        /*
        mainLayout = (RelativeLayout) findViewById(R.id.informacionGeneral);
        mChart = new PieChart(this);
        mainLayout.addView(mChart);
        mainLayout.setBackgroundColor(Color.LTGRAY);
        mChart.setUsePercentValues(true);
        mChart.setContentDescription("letras");
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleRadius(7);
        mChart.setTransparentCircleRadius(10);

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                if(e == null){
                    return;
                }
            }

            @Override
            public void onNothingSelected() {

            }
        });
        addData();
         */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://covid.unnamed-chile.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servicio=retrofit.create(Servicio.class);
        Call<RespuestaNacionalWS>resp= servicio.nacional();
        resp.enqueue(new Callback<RespuestaNacionalWS>() {
            @Override
            public void onResponse(Call<RespuestaNacionalWS> call, Response<RespuestaNacionalWS> response) {
                if(response.isSuccessful()){
                    if(response.body().getEstado().toString()=="true"){
                        texto1= findViewById(R.id.text1);
                        texto2=findViewById(R.id.text2);
                        texto3=findViewById(R.id.text3);
                        texto4=findViewById(R.id.text4);
                        texto5=findViewById(R.id.text5);
                        texto6=findViewById(R.id.text6);
                        texto7=findViewById(R.id.text7);
                        texto8=findViewById(R.id.text8);
                        texto1.setText(response.body().getFecha());
                        texto2.setText(response.body().getReporte().getAcumulado_total()+"");
                        texto3.setText(response.body().getReporte().getCasos_nuevos_total()+"");
                        texto4.setText(response.body().getReporte().getCasos_nuevos_snotificar()+"");
                        texto5.setText(response.body().getReporte().getCasos_activos_confirmados()+"");
                        texto6.setText(response.body().getReporte().getCasos_nuevos_csintomas()+"");
                        texto7.setText(response.body().getReporte().getCasos_nuevos_ssintomas()+"");
                        texto8.setText(response.body().getReporte().getFallecidos()+"");


                    }
                }
            }

            @Override
            public void onFailure(Call<RespuestaNacionalWS> call, Throwable t) {

            }
        });
    }
    /*
    private void addData(){
        ArrayList<PieEntry> yVals1 = new ArrayList<PieEntry>();
        for(int i =0; i<yData.length;i++){
            yVals1.add(new PieEntry(yData[i],i));

        }
        ArrayList<String> xVals = new ArrayList<String>();
        for(int i =0; i<xData.length;i++){
            xVals.add(xData[i]);
        }
        PieDataSet dataSet = new PieDataSet(yVals1,"valoresy");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c);
        }
        for (int c: ColorTemplate.JOYFUL_COLORS) {
            colors.add(c);
        }
        for (int c: ColorTemplate.COLORFUL_COLORS) {
            colors.add(c);
        }
        for (int c: ColorTemplate.LIBERTY_COLORS) {
            colors.add(c);
        }
        for (int c: ColorTemplate.PASTEL_COLORS) {
            colors.add(c);
        }
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        PieData data = new PieData(xVals,dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.GRAY);

        mChart.setData(data);
        mChart.highlightValues(null);
        mChart.invalidate();

    }
     */
    public void onClickBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
