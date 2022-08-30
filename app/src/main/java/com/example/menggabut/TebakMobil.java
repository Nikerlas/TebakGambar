package com.example.menggabut;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Bundle;

public class TebakMobil extends AppCompatActivity {

    ImageView iv_tebak;
    EditText et_jawab;
    Button btn_cek;

    String jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tebak_mobil);

        setInisialisasi();
        cekIntent();
        onClickJos();

    }

    private void cekIntent(){
        Intent cek = getIntent();
        String nama_icon =
                cek.getStringExtra("nama_icon");
        if (nama_icon.equals("toyota")) {
            iv_tebak.setImageResource(R.drawable.toyota);
            jawaban = "toyota";
        }
    }

    private void onClickJos(){
        btn_cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_jawab.getText().toString().equals(jawaban)){
                   Toast.makeText(TebakMobil.this, "Jawaban anda benar!", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(TebakMobil.this, TebakMobil1.class);
                   intent.putExtra("nama_icon", "nissan");
                   startActivity(intent);
                }else{
                    Toast.makeText(TebakMobil.this, "Jawaban anda salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setInisialisasi(){
        iv_tebak = (ImageView) findViewById(R.id.imageView_tebak);
        et_jawab = (EditText) findViewById(R.id.editText_jawab);
        btn_cek = (Button) findViewById(R.id.buttonCek);
    }
}