package com.example.marvelapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marvelapp.model.Personagem;
import com.example.marvelapp.model.PersonagemNetwork;

import java.io.IOException;

public class DetalhePersonagemActivity extends AppCompatActivity {
    private TextView titulo, descricao;
    private ImageView backdrop;
    private ProgressBar progressBar;
    private Personagem personagem;
    private String imgUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_personagem);
        titulo = (TextView)findViewById(R.id.txt_titulo);
        descricao = (TextView)findViewById(R.id.txt_descricao);
        Intent intent = getIntent();
        personagem = (Personagem)intent.getSerializableExtra(ListarPersonagensActivity.PERSONAGEM);
        titulo.setText(personagem.getTitulo());
        descricao.setText(personagem.getDescricao());
        progressBar = (ProgressBar)findViewById(R.id.progressBarDetalhe);
        if (PersonagemNetwork.isConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            String msg = this.getResources().getString(R.string.erro_rede);
            Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private class DownloadBackdrop extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap img = null;
            try {
                img = PersonagemNetwork.buscarImagens(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return img;
        }

        protected void onPostExecute(Bitmap img){
            backdrop.setImageBitmap(img);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}