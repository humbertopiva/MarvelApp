package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;
import com.example.marvelapp.model.Dados;
import com.example.marvelapp.model.Personagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarPersonagensActivity extends AppCompatActivity {
    public static final String PERSONAGEM = "com.example.marvelapp.personagem";
    Personagem[] lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personagens);
        atividade = this;
        final Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = Dados.buscaPersonagens(chave);
        BaseAdapter adapter = new PersonagemAdapter(this, lista);


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