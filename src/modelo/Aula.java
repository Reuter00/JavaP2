package modelo;
import modelo.divisoes.Sala;
import modelo.pessoas.Aluno;
import modelo.pessoas.Professor;

import java.util.LinkedList;

public class Aula extends Identificador {
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;
    private Sala sala;

    //Constructor
    public Aula(String nome, long numero, Horario horario, Sala sala){
    this(nome,numero, horario,sala, null, new LinkedList<>());
   /* this.numero=numero;
    this.sumario = new StringBuilder();
    this.professor = null;
    this.alunos=new LinkedList<>();*/  //porque vai buscar tudo ao construtor de baixo (menos a parte unica)
    }

    public  Aula(String nome, long numero, Horario horario,Sala sala, Professor professor, LinkedList<Aluno> alunos) {
        super(nome, numero);
        this.horario = horario;
        this.sumario = new StringBuilder();
        setProfessor(professor);
        setSala(sala);

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

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        if (sala == null || this.sala == sala){
            return;
        }
        desassociarSala();

        this.sala = sala;
        this.sala.adicioar(this);
    }

    public void desassociarSala(){
        if (this.sala == null){
            return;
        }
        Sala salaARemover = this.sala;
        this.sala = null;
        salaARemover.remover(this);
    }

    //Function Professor

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if(professor==null || this.professor==professor) { // verifica se passaram
            return; //um professor
        }

            desassociarProfessor();

        this.professor = professor;
        this.professor.adicionar(this);
    }

    public void desassociarProfessor() {
        if (professor == null) {
            return;
        }

        Professor professorARemover = professor;
        professor = null;
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