package com.example.marvelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    public static final String NOME = "com.example.appfilmes.nome";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_fila);
    }

    public void buscarPersonagens(View view) {
        String nome = txtNome.getText().toString();
        Intent intent = new Intent(this, ListarPersonagensActivity.class);
        intent.putExtra(NOME, nome);
        startActivity(intent);

    }
}