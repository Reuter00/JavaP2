package modelo;
import java.util.LinkedList;

public class Professor {
    private String nome;
    private long numero;
    private LinkedList<Aula> aulas;

    public Professor(String nome, long numero){
        this.nome=nome;
        this.numero=numero;
        this.aulas=new LinkedList<>();
    }


    //Dados do Professor
    public String getNome(){
        return this.nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
    //------------

    public void preencherSumario(Aula aula){
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(this.nome);
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    //Adicionar ou remover Aula
    public void adicionar(Aula aula){
        if(aula==null || aulas.contains(aula)){
            return;
        }
        aulas.add(aula);
        aula.setProfessor(this);
    }

    public void remover(Aula aula){
        if(!aulas.contains(aula)){
            return;
        }
        aulas.remove(aula);
        aula.desassociarProfessor();
    }
    //------------

}
