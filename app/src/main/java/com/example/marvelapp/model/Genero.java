package com.example.marvelapp.model;

public class Genero {
    private int id;
    private String nome;

    public Genero(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
