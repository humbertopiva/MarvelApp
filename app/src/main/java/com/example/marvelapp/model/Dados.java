package com.example.marvelapp.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dados {

    public static Personagem[] buscaPersonagens(String chave){
        ArrayList<Personagem> lista = criaPersonagem();
        if(chave == null || chave.length() == 0){
            return lista.toArray(new Personagem[0]);
        } else {
            ArrayList<Personagem> filtro = new ArrayList<>();
            for(Personagem personagem: lista){
                String nome = personagem.getNome();
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(personagem);
                }
            }
            return filtro.toArray(new Personagem[0]);
        }
    }

    public static ArrayList<String> geraListaPersonagens(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Deadpool");
        lista.add("Galactus");
        lista.add("Homem-Aranha");
        lista.add("Homem-Formiga");
        lista.add("Hulk");
        lista.add("Loki");
        lista.add("Pantera Negra");
        lista.add("Thor");
        lista.add("Venom");
        lista.add("Wolverine");

        return lista;
    }

    public static ArrayList<Genero> criaGeneros() {
        ArrayList<Genero> lista = new ArrayList<>();
        lista.add(new Genero(1, "Herói"));
        lista.add(new Genero(2, "Vilão"));
        lista.add(new Genero(3, "Anti-herói"));

        return lista;
    }

    public static ArrayList<Personagem> criaPersonagem() {
        ArrayList<Personagem> lista = new ArrayList<>();
        Personagem personagem;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        personagem = new Personagem();
        personagem.setPopularidade(35.503);
        personagem.setPosterPath("deadpool.jpg");
        personagem.setBackdropPath("a");
        personagem.setGenero(new Genero(3, "Anti-herói"));
        personagem.setNome("Deadpool");
        personagem.setDescricao("Deadpool (Wade Winston Wilson) é um personagem fictício do universo Marvel, que atua geralmente como anti-herói e ocasionalmente como vilão. " +
                "Deadpool, cujo nome verdadeiro é Wade Winston Wilson, é um mercenário canadense marcado por ser falastrão e violento. Tem também o fator de cura que o faz " +
                "sobreviver aos piores ferimentos.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1991-01-27"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPopularidade(125.00);
        personagem.setPosterPath("galactus.jpg");
        personagem.setBackdropPath("a");
        personagem.setGenero(new Genero(2, "Vilão"));
        personagem.setNome("Galactus");
        personagem.setDescricao("Galactus, também conhecido como Devorador de Mundos, é um personagem de histórias em quadrinhos, uma entidade cósmica dentro do universo Marvel" +
                " da Marvel Comics. Criado por Stan Lee e Jack Kirby, ele estreou em Quarteto Fantástico nº48, o inicio de um arco de história algumas vezes considerado como a m" +
                "elhor colaboração entre Lee e Kirby.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1966-05-14"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPopularidade(352.029);
        personagem.setPosterPath("homemaranha.jpg");
        personagem.setBackdropPath("a");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setNome("Homem-Aranha");
        personagem.setDescricao("O Homem-Aranha (Spider-Man no original) o alter-ego de Peter Parker, é um personagem fictício, um super-herói que aparece nas revistas em quadrinhos" +
                " (banda desenhada em Portugal) americanas publicadas pela Marvel Comics, existindo no seu universo partilhado.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1962-08-07"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPopularidade(346.752);
        personagem.setPosterPath("homemformiga.jpg");
        personagem.setBackdropPath("a");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setNome("Homem-Formiga");
        personagem.setDescricao("s partículas Pym permitem a ele alterar seu tamanho e ter força sobre-humana, e seu capacete permite controlar e se comunicar com insetos, principalmente as " +
                "formigas, na maioria das vezes ele voa em cima da formiga rainha. E ele também pode crescer e ficar do tamanho de um prédio ficando mais forte, porém não pode se comunicar com " +
                "insetos quando fica gigante.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1962-01-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPopularidade(38.69);
        personagem.setPosterPath("hulk.jpg");
        personagem.setBackdropPath("a");
        personagem.setGenero(new Genero(3, "Anti-herói"));
        personagem.setNome("Hulk");
        personagem.setDescricao("Na história original dos quadrinhos, o Hulk é um selvagem e poderoso alter ego do Dr. Robert Bruce Banner, um cientista que foi atingido por raios gama enquanto salvava " +
                "um adolescente durante o teste militar de uma bomba por ele desenvolvida. Este adolescente, Rick Jones, tornou-se companheiro de Banner, ajudando-o a manter o Hulk sob controle e mantê-lo " +
                "longe dos ataques dos militares, que viam a criatura como uma ameaça.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1962-05-30"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPopularidade(23.35);
        personagem.setPosterPath("loki.jpg");
        personagem.setBackdropPath("a");
        personagem.setGenero(new Genero(2, "Vilão"));
        personagem.setNome("Loki");
        personagem.setDescricao("Loki Laufeyson é um personagem fictício e um supervilão, irmão de Thor, e é considerado também um dos principais adversários dos Vingadores. Loki também já foi inimigo de " +
                "Thor em algumas ocasiões. Ele aparece nas histórias em quadrinhos publicadas pela Marvel Comics, ele é baseado no deus Loki da Mitologia Nórdica.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1962-10-06"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPopularidade(25.3);
        personagem.setPosterPath("panteranegra.jpg");
        personagem.setBackdropPath("a");
        personagem.setNome("Pantera Negra");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setDescricao("Pantera Negra (em inglês: Black Panther) é um super-herói das histórias em quadrinhos publicadas pela Marvel Comics, cuja identidade secreta é a de T'Challa, rei de Wakanda," +
                " um reino fictício na África. O personagem foi criado pelo escritor e editor Stan Lee e pelo escritor e ilustrador Jack Kirby, aparecendo pela primeira vez em Fantastic Four # 52 (julho de 1966)" +
                " na Era de Prata das histórias em quadrinhos.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1966-07-08"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPopularidade(28.44);
        personagem.setPosterPath("thor.jpg");
        personagem.setBackdropPath("a");
        personagem.setGenero(new Genero(1, "Herói"));
        personagem.setNome("Thor");
        personagem.setDescricao("Thor, também sendo o Vingador mais poderoso dos Cinemas (UCM) e dos quadrinhos,Também está Prestes a deixar o seu Legado nas Telonas.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1962-08-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPopularidade(25.19);
        personagem.setPosterPath("venom.jpg");
        personagem.setBackdropPath("a");
        personagem.setGenero(new Genero(2, "Vilão"));
        personagem.setNome("Venom");
        personagem.setDescricao("enom é um personagem ficcional das histórias em quadrinhos na série do Homem-Aranha do Universo Marvel, publicadas pela Marvel Comics. " +
                "Apesar de já ter tido minisséries próprias, a maioria de suas aparições é como inimigo do personagem Homem-Aranha. Apesar de ter seu lado como vilão, Venom " +
                "também é um anti-herói.");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1988-04-11"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);
        personagem = new Personagem();
        personagem.setPopularidade(28.37);
        personagem.setPosterPath("wolverine.jpg");
        personagem.setBackdropPath("a");
        personagem.setGenero(new Genero(3, "Anti-herói"));
        personagem.setNome("Wolverine");
        personagem.setDescricao("Wolverine (nascido James Howlett[1] conhecido como Logan e às vezes como Arma X) é um personagem fictício que aparece em quadrinhos americanos " +
                "publicados pela Marvel Comics, principalmente em associação com os X-Men");
        try {
            personagem.setDataLancamento((Date) formatter.parse("1974-11-13"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(personagem);

        return lista;
    }
}
