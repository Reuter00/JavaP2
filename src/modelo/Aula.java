package modelo;
import java.util.LinkedList;

public class Aula {
    private String nome;
    private long numero;
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;

    //Constructor
    public Aula(String nome, long numero){
    this(nome,numero,null,new LinkedList<>());
   /* this.numero=numero;
    this.sumario = new StringBuilder();
    this.professor = null;
    this.alunos=new LinkedList<>();*/  //porque vai buscar tudo ao construtor de baixo (menos a parte unica)
    }

    public  Aula(String nome, long numero, Professor professor, LinkedList<Aluno> alunos) {
        this.nome = nome;
        this.numero = numero;
        this.sumario = new StringBuilder();
        setProfessor(professor);
        this.alunos = new LinkedList<>();
        for (Aluno aluno : alunos) {
            adicionar(aluno);
        }
    }


    //Function Aula
    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getSumario() { return sumario.toString(); }

    

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



    //Functions Aluno
    public LinkedList<Aluno> getAlunos() {
        return new LinkedList<>(alunos);
    }

    public void desassociarProfessor(){
        if(this.professor==null){
            return;
        }

        Professor professorARemover=this.professor;
        this.professor=null;
        professorARemover.remover(this);


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