package com.example.marvelapp;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView posterPersonagem;
    private TextView nomePersonagem, DetalhePersonagem;

    public ViewHolder(ImageView posterPersonagem, TextView nomePersonagem, TextView detalhePersonagem) {
        this.posterPersonagem = posterPersonagem;
        this.nomePersonagem = nomePersonagem;
        DetalhePersonagem = detalhePersonagem;
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

    public TextView getDetalhePersonagem() {
        return DetalhePersonagem;
    }

    public void setDetalhePersonagem(TextView detalhePersonagem) {
        DetalhePersonagem = detalhePersonagem;
    }
}
