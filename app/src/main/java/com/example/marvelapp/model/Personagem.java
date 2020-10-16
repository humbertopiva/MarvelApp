package com.example.marvelapp.model;

import java.io.Serializable;

public class Personagem implements Serializable, Comparable<Personagem> {
    private int id;
    private String titulo;
    private String descricao;
    private String posterPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "id=" + id +
                ", nome='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", posterPath='" + posterPath + '\'' +
                '}';
    }

    @Override
    public int compareTo(Personagem personagem) {
        return getTitulo().compareTo(personagem.getTitulo());
    }
}
