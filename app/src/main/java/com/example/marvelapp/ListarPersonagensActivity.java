package com.example.marvelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marvelapp.model.Dados;
import com.example.marvelapp.model.Personagem;
import com.example.marvelapp.model.Poster;

import java.util.ArrayList;

public class ListarPersonagensActivity extends AppCompatActivity {
    public static final String PERSONAGEM = "com.example.marvelapp.personagem";
    Personagem[] lista;
    Poster[] posters;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personagens);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        ArrayList<Personagem> personagens = (ArrayList<Personagem>) intent.getSerializableExtra(MainActivity.PERSONAGENS);
        Dados.setPersonagens(personagens);

        lista = Dados.buscaPersonagens(chave);
        posters = Dados.buscaPosters(chave);

        BaseAdapter adapter = new PersonagemAdapter(this, lista, posters);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(atividade, DetalhePersonagemActivity.class);
                intent1.putExtra(PERSONAGEM, lista[i]);
                startActivity(intent1);
            }
        });

    }

}