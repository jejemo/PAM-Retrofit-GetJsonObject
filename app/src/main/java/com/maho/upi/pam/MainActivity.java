package com.maho.upi.pam;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.maho.upi.pam.Model.ModelData;
import com.maho.upi.pam.Apis.ApiService;
import com.maho.upi.pam.Apis.ApiInterface;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    Button generate;
    Button clear;
    TextView nama;
    TextView  nopung;
    TextView tim;
    TextView posisi;
    TextView negara;
    TextView deskripsi;
    TextView age, txt;
    ImageView gambar;
    ImageView ikon;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ikon = (ImageView)findViewById((R.id.ikon));
        gambar = (ImageView)findViewById(R.id.gambar);

        nama = (TextView)findViewById(R.id.txtNama);
        age = (TextView)findViewById(R.id.txtAge);
        nopung = (TextView)findViewById(R.id.txtNomor);
        tim = (TextView)findViewById(R.id.txtTeam);
        posisi = (TextView)findViewById(R.id.txtPosisi);
        negara = (TextView)findViewById(R.id.txtNegara);
        deskripsi = (TextView)findViewById(R.id.txtDeskripsi);
        txt = (TextView)findViewById(R.id.txt);
        generate = (Button)findViewById(R.id.btnLoad);

        clear = (Button)findViewById(R.id.btnClear);

        //btnload
        btnload();
        //btnclear
    }

    private void btnload() {
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Get Data");
                progressDialog.setMessage("Loading ...");
                progressDialog.show();

                getData(); //call method
            }
        });
    }


    private void getData() {
        //Download Json via Retrofit
        ApiInterface apiInterface = ApiService.getDataPemain().create(ApiInterface.class);

        //Call Object
        Call<ModelData> call = apiInterface.getPemain();

        call.enqueue(new Callback<ModelData>() {
            @Override
            public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                progressDialog.dismiss();
               // ModelData datagambar = response.body();

                    nama.setText("" + response.body().getNama());
                    age.setText(": " + response.body().getAge());
                    nopung.setText("" + response.body().getNomor());
                    tim.setText("" + response.body().getTim());
                    posisi.setText(": " + response.body().getPosisi());
                    negara.setText(": " + response.body().getNegara());
                    deskripsi.setText("" + response.body().getDeskripsi());
                    String gambar1 = new String(""+response.body().getGambar());
                    String ikon1 = new String(""+response.body().getIkon());
                    Picasso.with(getApplicationContext()).load(gambar1).into(gambar);
                Picasso.with(getApplicationContext()).load(ikon1).into(ikon);
            }

            @Override
            public void onFailure(Call<ModelData> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Failed to load", Toast.LENGTH_LONG).show();
            }
        });
    }
}
