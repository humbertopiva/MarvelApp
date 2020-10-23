package com.example.marvelapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.marvelapp.model.Personagem;
import com.example.marvelapp.model.Poster;

import java.util.Hashtable;

public class PersonagemAdapter extends BaseAdapter implements SectionIndexer {
    private Personagem[] personagens;
    private Context context;
    Object[] sectionHeaders;
    Poster[] imagens;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public PersonagemAdapter(Context context, Personagem[] personagens, Poster[] imagens) {
        this.personagens = personagens;
        this.context = context;
        this.imagens = imagens;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(personagens);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(personagens);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPositionMap(personagens);
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
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_personagem, viewGroup, false);
            ImageView posterPersonagem = (ImageView) view.findViewById(R.id.poster_personagem);
            TextView nomePersonagem = (TextView) view.findViewById(R.id.nome_personagem);
            TextView detalhe1Personagem = (TextView) view.findViewById(R.id.detalhe1_personagem);
            TextView detalhe2Personagem = (TextView) view.findViewById(R.id.detalhe2_personagem);
            TextView detalhe3Personagem = (TextView) view.findViewById(R.id.detalhe3_personagem);
            ViewHolder viewHolder = new ViewHolder(posterPersonagem, nomePersonagem, detalhe1Personagem,
                    detalhe2Personagem, detalhe3Personagem);
            view.setTag(viewHolder);
        }

        Drawable drawable = Util.getDrawable(context,
                personagens[i].getPosterPath().substring(0,
                        personagens[i].getPosterPath().length()-4).toLowerCase());
        ViewHolder viewHolder = (ViewHolder)view.getTag();
        viewHolder.getPosterPersonagem().setImageDrawable(drawable);
        viewHolder.getNomePersonagem().setText(personagens[i].getTitulo());
        //Locale locale = new Locale("pt", "BR");

        return view;
    }

    @Override
    public Object[] getSections() {
        System.out.println(sectionHeaders);
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int i) {
        return positionForSectionMap.get(i).intValue();
    }

    @Override
    public int getSectionForPosition(int i) {
        return sectionForPositionMap.get(i).intValue();
    }
}
