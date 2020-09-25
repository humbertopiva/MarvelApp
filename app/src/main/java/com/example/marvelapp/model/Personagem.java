package com.example.marvelapp.model;

import java.io.Serializable;
import java.util.Date;

public class Personagem implements Serializable, Comparable<Personagem> {
    private int id;
    private String nome;
    private String descricao;
    private double popularidade;
    private Date dataLancamento;
    private String posterPath;
    private String backdropPath;
    private String diretor;
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

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", popularidade=" + popularidade +
                ", dataLancamento=" + dataLancamento +
                ", posterPath='" + posterPath + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", diretor='" + diretor + '\'' +
                ", genero=" + genero +
                '}';
    }

    @Override
    public int compareTo(Personagem personagem) {
        return getNome().compareTo(personagem.getNome());
    }
}
