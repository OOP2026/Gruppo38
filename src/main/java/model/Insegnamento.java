package model;

public class Insegnamento {
    private String nome;
    private int cfu;
    private AnnoAccademico anno;

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    private Docente docente;
    public Insegnamento(Docente docente, String nome, int cfu, AnnoAccademico anno) {
        this.docente = docente;
        this.nome = nome;
        this.cfu = cfu;
        this.anno = anno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public AnnoAccademico getAnno() {
        return anno;
    }

    public void setAnno(AnnoAccademico anno) {
        this.anno = anno;
    }
}