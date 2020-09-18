package com.example.marvelapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvelapp.model.Personagem;

public class PersonagemAdapter extends BaseAdapter {
    private Personagem[] personagens;
    private Context context;

    public PersonagemAdapter(Context context, Personagem[] personagens) {
        this.personagens = personagens;
        this.context = context;
    }

    @Override
    public int getCount() {
        return personagens.length;
    }

    @Override
    public Object getItem(int i) {
        if(i >= 0 && i < personagens.length) {
            return personagens[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_personagem, viewGroup, false);
            ImageView posterFilme = (ImageView) view.findViewById(R.id.poster_personagem);
            TextView nomeFilme = (TextView) view.findViewById(R.id.nome_personagem);
            TextView detalheFilme = (TextView) view.findViewById(R.id.detalhe_personagem);
            view.setTag(new ViewHolder(posterFilme, nomeFilme, detalheFilme));
        }
        ViewHolder holder = (ViewHolder)view.getTag();
        Drawable drawable = Util.getDrawable(context,
                personagens[i].getPosterPath().substring(0,
                        personagens[i].getPosterPath().length()-4).toLowerCase());
        holder.getPosterPersonagem().setImageDrawable(drawable);
        holder.getNomePersonagem().setText(personagens[i].getNome());
        holder.getDetalhePersonagem().setText(String.format("%s - direção: %s", personagens[i].getGenero().getNome()));

        return view;
    }
}
