package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PorRegionActivity extends AppCompatActivity {
    private Spinner spinner;
    private Servicio servicio;
    private ArrayAdapter<String> adapter;
    private TextView datos1,datos2,datos3,datos4,datos5,datos6,datos7,datos8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_por_region);
        spinner= (Spinner) findViewById(R.id.regions_spinner);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(" http://covid.unnamed-chile.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servicio = retrofit.create(Servicio.class);
        Call<RespuestaRegionWS>resp=servicio.regiones();
        resp.enqueue(new Callback<RespuestaRegionWS>() {
            @Override
            public void onResponse(Call<RespuestaRegionWS> call, Response<RespuestaRegionWS> response) {
                if(response.isSuccessful()){
                    List<String> nombreRegion = new ArrayList<>();
                    for (int i = 0; i < response.body().getRegiones().size(); i++) {
                        nombreRegion.add(response.body().getRegiones().get(i).getNombre());
                    }
                    adapter = new ArrayAdapter<>(getApplication(),android.R.layout.simple_spinner_item,nombreRegion);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            System.out.println(position);
                            Call<RespuestaNacionalWS> respuestaNacionalWSCall = servicio.porRegion("api/data/"+(
                                    spinner.getSelectedItemPosition()+1
                                    ));
                            respuestaNacionalWSCall.enqueue(new Callback<RespuestaNacionalWS>() {
                                @Override
                                public void onResponse(Call<RespuestaNacionalWS> call, Response<RespuestaNacionalWS> response) {
                                    if(response.isSuccessful()) {
                                        datos1=findViewById(R.id.datos1);
                                        datos2=findViewById(R.id.datos2);
                                        datos3=findViewById(R.id.datos3);
                                        datos4=findViewById(R.id.datos4);
                                        datos5=findViewById(R.id.datos5);
                                        datos6=findViewById(R.id.datos6);
                                        datos7=findViewById(R.id.datos7);
                                        datos8=findViewById(R.id.datos8);
                                        datos1.setText(response.body().getFecha());
                                        datos2.setText(response.body().getReporte().getAcumulado_total()+"");
                                        datos3.setText(response.body().getReporte().getCasos_nuevos_total()+"");
                                        datos4.setText(response.body().getReporte().getCasos_nuevos_csintomas()+"");
                                        datos5.setText(response.body().getReporte().getCasos_nuevos_ssintomas()+"");
                                        datos6.setText(response.body().getReporte().getCasos_nuevos_snotificar()+"");
                                        datos7.setText(response.body().getReporte().getFallecidos()+"");
                                        datos8.setText(response.body().getReporte().getCasos_activos_confirmados()+"");


                                    }
                                }

                                @Override
                                public void onFailure(Call<RespuestaNacionalWS> call, Throwable t) {

                                }
                            });

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

            }
            @Override
            public void onFailure(Call<RespuestaRegionWS> call, Throwable t) {
                Log.d("Retrofit", t.getMessage());
            }
        });
    }
    public void onClickBack(View v){
        Intent intent = new Intent(this, InformacionDetalladaActivity.class);
        startActivity(intent);
        finish();
    }

}
