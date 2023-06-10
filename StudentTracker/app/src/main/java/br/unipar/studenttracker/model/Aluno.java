package br.unipar.studenttracker.model;

public class Aluno {

    private int ra;
    private String nome;
    private String disciplina;
    private double nota;
    private int bimestre;

    public Aluno(int ra, String nome, String disciplina, double nota, int bimestre) {
        this.ra = ra;
        this.nome = nome;
        this.disciplina = disciplina;
        this.nota = nota;
        this.bimestre = bimestre;
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

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getBimestre() {
        return bimestre;
    }

    public void setBimestre(int bimestre) {
        this.bimestre = bimestre;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", nota=" + nota +
                ", bimestre=" + bimestre +
                '}';
    }
}

