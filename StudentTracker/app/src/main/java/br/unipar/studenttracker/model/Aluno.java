package br.unipar.studenttracker.model;

public class Aluno {
    private int ra;
    private String nome;
    private Double priBim;
    private Double segBim;
    private Double tercBim;
    private Double quarBim;
    private String disciplina;


    public Aluno() {

    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public double calcularMedia(Aluno aluno) {
        Double priBim = aluno.getPriBim() != null ? aluno.getPriBim() : 0.0;
        Double segBim = aluno.getSegBim() != null ? aluno.getSegBim() : 0.0;
        Double tercBim = aluno.getTercBim() != null ? aluno.getTercBim() : 0.0;
        Double quarBim = aluno.getQuarBim() != null ? aluno.getQuarBim() : 0.0;

        return (priBim + segBim + tercBim + quarBim) / 4;
    }

}
