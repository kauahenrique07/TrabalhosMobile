package br.unipar.studenttracker.model;

public class Aluno {

    private String ra;
    private String nome;
    private String disciplina;
    private String nota;
    private String bimestre;

    public Aluno(String ra, String nome, String disciplina, String nota, String bimestre) {
        this.ra = ra;
        this.nome = nome;
        this.disciplina = disciplina;
        this.nota = nota;
        this.bimestre = bimestre;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getBimestre() {
        return bimestre;
    }

    public void setBimestre(String bimestre) {
        this.bimestre = bimestre;
    }

    @Override
    public String toString() {
        return nome;
    }
}
