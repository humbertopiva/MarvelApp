package com.example.marvelapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.marvelapp.model.Personagem;

public class DetalhePersonagemActivity extends AppCompatActivity {
    private TextView nomeDoPersonagem, genero, lancamento, popularidade, descricao;
    private ImageView backdrop;
    private Personagem personagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalhe_personagem);
        nomeDoPersonagem = (TextView)findViewById(R.id.txt_nome);
        genero = (TextView)findViewById(R.id.txt_genero);
        lancamento = (TextView)findViewById(R.id.txt_lancamento);
        popularidade = (TextView)findViewById(R.id.txt_popularidade);
        descricao = (TextView)findViewById(R.id.txt_descricao);
        Intent intent = getIntent();
        personagem = (Personagem) intent.getSerializableExtra(ListarPersonagensActivity.PERSONAGEM);
        nomeDoPersonagem.setText(personagem.getNome());
        genero.setText(personagem.getGenero().getNome());
        descricao.setText(personagem.getDescricao());
        lancamento.setText(String.format("%td/%tB/%tY",
                personagem.getDataLancamento(),
                personagem.getDataLancamento(),
                personagem.getDataLancamento()));
        popularidade.setText(String.format("%.1f", personagem.getPopularidade()));
    }
}