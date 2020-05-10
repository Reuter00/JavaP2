package modelo;
import modelo.pessoas.Aluno;
import modelo.pessoas.Professor;

import java.util.LinkedList;

public class Aula extends Identificador {
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;

    //Constructor
    public Aula(String nome, long numero, Horario horario){
    this(nome,numero, horario,null, new LinkedList<>());
   /* this.numero=numero;
    this.sumario = new StringBuilder();
    this.professor = null;
    this.alunos=new LinkedList<>();*/  //porque vai buscar tudo ao construtor de baixo (menos a parte unica)
    }

    public  Aula(String nome, long numero, Horario horario, Professor professor, LinkedList<Aluno> alunos) {
        super(nome, numero);
        this.horario = horario;
        this.sumario = new StringBuilder();
        setProfessor(professor);

        this.alunos = new LinkedList<>();
        for (Aluno aluno : alunos) {
            adicionar(aluno);
        }
    }


    //Function Aula

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Horario getHorario() {
        return horario;
    }

    public String getSumario() { return sumario.toString(); }

    @Override
    public String getNome(){
        return "Aula: " + super.getNome();
    }


    //Function Professor

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if(professor==null || this.professor==professor) { // verifica se passaram
            return; //um professor
        }
        if (this.professor!=null){
            desassociarProfessor();
        }
        this.professor = professor;
        this.professor.adicionar(this);
    }

    public void desassociarProfessor() {
        if (this.professor == null) {
            return;
        }

        Professor professorARemover = this.professor;
        this.professor = null;
        professorARemover.remover(this);
    }



    //Functions Aluno
    public LinkedList<Aluno> getAlunos() {
        return new LinkedList<>(alunos);
    }



    public void adicionar(Aluno aluno){
        if(aluno==null || this.alunos.contains(aluno)) {
            return;
        }
        this.alunos.add(aluno);
        aluno.adicionar(this);
    }

    public void remover(Aluno aluno){
        if (alunos.remove(aluno)){
            aluno.remover(this);
        }

    }


    public void adicionarLinhaSumario(String linha){
       sumario.append(linha).append("\n");

    }



}