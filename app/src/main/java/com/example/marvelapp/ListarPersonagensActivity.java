package com.example.marvelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListarPersonagensActivity extends AppCompatActivity {
    public static final String DESCRICAO = "com.example.marvelapp.descricao";
    Activity atividade;

    ArrayList<String> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personagens);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(com.example.marvelapp.MainActivity.NOME);
        lista = buscaPersonagens(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(atividade, DetalhePersonagemActivity.class);
                intent1.putExtra(DESCRICAO, lista.get(i));
                startActivity(intent1);
            }
        });
    }

    private ArrayList<String> buscaPersonagens(String chave){
        ArrayList<String> lista = geraListaPersonagens();
        if(chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> filtro = new ArrayList<>();
            for(String nome: lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(nome);
                }
            }
            return filtro;
        }
    }

    private ArrayList<String> geraListaPersonagens(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Batroc");
        lista.add("Hellcat");
        lista.add("Galactus");
        lista.add("Frogman");
        lista.add("Capitão América");
        lista.add("Medusa");
        lista.add("Fera");
        lista.add("Visão");
        lista.add("Falcão");
        lista.add("Demolidor");
        lista.add("Surfista Prateado");
        lista.add("Homem Aranha");

        return lista;
    }
}