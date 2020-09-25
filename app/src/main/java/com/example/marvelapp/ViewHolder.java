package com.example.marvelapp;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView posterPersonagem;
    private TextView nomePersonagem, detalhe1Personagem, detalhe2Personagem, detalhe3Personagem;

    public ViewHolder(ImageView posterPersonagem, TextView nomePersonagem, TextView detalhe1Personagem, TextView detalhe2Personagem, TextView detalhe3Personagem) {
        this.posterPersonagem = posterPersonagem;
        this.nomePersonagem = nomePersonagem;
        this.detalhe1Personagem = detalhe1Personagem;
        this.detalhe2Personagem = detalhe2Personagem;
        this.detalhe3Personagem = detalhe3Personagem;
    }

    public ImageView getPosterPersonagem() {
        return posterPersonagem;
    }

    public void setPosterPersonagem(ImageView posterPersonagem) {
        this.posterPersonagem = posterPersonagem;
    }

    public TextView getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(TextView nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public TextView getDetalhe1Personagem() { return detalhe1Personagem; }

    public void setDetalhe1Personagem(TextView detalhe1Personagem) { this.detalhe1Personagem = detalhe1Personagem; }

    public TextView getDetalhe2Personagem() {
        return detalhe2Personagem;
    }

    public void setDetalhe2Personagem(TextView detalhe2Personagem) { this.detalhe2Personagem = detalhe2Personagem; }

    public TextView getDetalhe3Personagem() {
        return detalhe3Personagem;
    }

    public void setDetalhe3Personagem(TextView detalhe3Personagem) { this.detalhe3Personagem = detalhe3Personagem; }
}
