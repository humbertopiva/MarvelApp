package com.example.marvelapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marvelapp.model.Dados;
import com.example.marvelapp.model.Personagem;
import com.example.marvelapp.model.PersonagemNetwork;
import com.example.marvelapp.model.Poster;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    private ProgressBar progressBar;
    public static final String NOME = "com.example.marvelapp.nome";
    public static final String PERSONAGENS = "com.example.marvelapp.personagens";
    private String url = "https://gateway.marvel.com:443/v1/public/characters?apikey=";
    private String imgUrl = "http://i.annihil.us/u/prod/marvel/i/mg/c";

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_fila);
        progressBar = (ProgressBar)findViewById(R.id.progressBarMain);
        context = this;
    }

    public void buscarPersonagens(View view){
        if (PersonagemNetwork.isConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
            String idioma = this.getResources().getString(R.string.idioma);
            String pais = this.getResources().getString(R.string.pais);
            new DownloadJsonPersonagens().execute(String.format(url, idioma, pais) + getKey());
        } else {
            String msg = this.getResources().getString(R.string.erro_rede);
            Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private class DownloadJsonPersonagens extends AsyncTask<String, Void, ArrayList<Personagem>>{

        @Override
        protected ArrayList<Personagem> doInBackground(String... strings) {
            ArrayList<Personagem> personagens = new ArrayList<>();
            ArrayList<Poster> imagens = new ArrayList<>();
            try {
                personagens = PersonagemNetwork.buscarPersonagens(strings[0]);
                for(Personagem personagem: personagens){

                    String poster = personagem.getPosterPath();
                    Bitmap img = PersonagemNetwork.buscarImagens(imgUrl+poster);
                    Poster p = new Poster();
                    p.setId(personagem.getId());
                    p.setTitulo(personagem.getTitulo());
                    p.setPoster(img);
                    imagens.add(p);
                }
                Dados.setImagens(imagens);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return personagens;
        }

        protected void onPostExecute(ArrayList<Personagem> personagens){
            Intent intent = new Intent(context, ListarPersonagensActivity.class);
            String nome = txtNome.getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(PERSONAGENS, personagens);
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(intent);
        }
    }

    private String getKey(){
        return "e92123d306d58ca2e986bea7cfca57a1";
    }

}