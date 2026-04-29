package model;

public class Aula {
    private String nome;
    private int capienza;

    public Aula(String nome, int capienza) {
        this.nome = nome;
        this.capienza = capienza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }
}