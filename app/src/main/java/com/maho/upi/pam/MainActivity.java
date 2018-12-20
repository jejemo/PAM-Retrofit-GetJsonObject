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

import java.util.List;

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

        //call method initview
        initview();

    }

    private void initview() {

        //initimageview
        ikon = (ImageView)findViewById((R.id.ikon));
        gambar = (ImageView)findViewById(R.id.gambar);

        //inittextview
        nama = (TextView)findViewById(R.id.txtNama);
        age = (TextView)findViewById(R.id.txtAge);
        nopung = (TextView)findViewById(R.id.txtNomor);
        tim = (TextView)findViewById(R.id.txtTeam);
        posisi = (TextView)findViewById(R.id.txtPosisi);
        negara = (TextView)findViewById(R.id.txtNegara);
        deskripsi = (TextView)findViewById(R.id.txtDeskripsi);
        txt = (TextView)findViewById(R.id.txt);

        //initbutton
        generate = (Button)findViewById(R.id.btnLoad);

        //call method btnload
        btnload();
    }

    private void btnload() {
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Sedang mengambil data");
                progressDialog.setMessage("Sabar ya mas");
                progressDialog.show();

                getData(); //call method
            }
        });
    }


    private void getData() {
        //Download Json via Retrofit
        ApiInterface apiInterface = ApiService.getDataPemain().create(ApiInterface.class);

        //Call Object
        Call<List<ModelData>> call = apiInterface.getPemain();

        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
                try {
                    List<ModelData> modelData = response.body();

                    for (int i = 0; i < modelData.size();i++) {
                        if (i == 3) {
                            nama.setText("" + modelData.get(i).getNama());
                            age.setText(": " + modelData.get(i).getAge());
                            nopung.setText("" + modelData.get(i).getNomor());
                            tim.setText("" + modelData.get(i).getTim());
                            posisi.setText(": " + modelData.get(i).getPosisi());
                            negara.setText(": " + modelData.get(i).getNegara());
                            deskripsi.setText("" + modelData.get(i).getDeskripsi());
                            String gambar1 = new String(""+ modelData.get(i).getGambar());
                            String ikon1 = new String(""+ modelData.get(i).getIkon());
                            Picasso.with(getApplicationContext()).load(gambar1).into(gambar);
                            Picasso.with(getApplicationContext()).load(ikon1).into(ikon);
                        }
                    }
                }catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Gagal ambil data", Toast.LENGTH_LONG).show();
            }
        });

        /*call.enqueue(new Call<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
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
                Toast.makeText(MainActivity.this, "Gagal ambil data", Toast.LENGTH_LONG).show();
            }*/
        //});
    }
}
