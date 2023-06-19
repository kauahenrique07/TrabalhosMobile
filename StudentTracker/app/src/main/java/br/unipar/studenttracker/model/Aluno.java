package br.unipar.studenttracker.model;

public class Aluno {
    private int ra;
    private String nome;
    private Double nota;

    private int bimestre;
    private Double priBim;
    private Double segBim;
    private Double tercBim;
    private Double quarBim;
    private String disciplina;


    public Aluno(String ra, String nome, String disciplina, String nota, String bimestre) {

    }

    public Aluno() {

    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() { return nota; }

    public void setNota(Double nota) { this.nota = nota; }

    public int getBimestre() { return bimestre; }

    public void setBimestre(int bimestre) { this.bimestre = bimestre; }

    public Double getPriBim() {
        return priBim;
    }

    public void setPriBim(Double priBim) {
        this.priBim = priBim;
    }

    public Double getSegBim() {
        return segBim;
    }

    public void setSegBim(Double segBim) {
        this.segBim = segBim;
    }

    public Double getTercBim() {
        return tercBim;
    }

    public void setTercBim(Double tercBim) {
        this.tercBim = tercBim;
    }

    public Double getQuarBim() {
        return quarBim;
    }

    public void setQuarBim(Double quarBim) {
        this.quarBim = quarBim;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

}