package com.example.marvelapp.model;

import java.util.Date;

public class Personagem {
    private int id;
    private String nome;
    private String descricao;
    private double popularidade;
    private Date dataLancamento;
    private String posterPath;
    private String backdropPath;
    private Genero genero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String titulo) {
        this.nome = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(double popularidade) {
        this.popularidade = popularidade;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }


    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", popularidade=" + popularidade +
                ", dataLancamento=" + dataLancamento +
                ", posterPath='" + posterPath + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", genero=" + genero +
                '}';
    }
}
