package modelo;
import java.util.LinkedList;

public class Professor extends Pessoa {

    public Professor(String nome, long numero){
        super(nome,numero);
    }



    @Override
    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        super.assinarSumario(aula);
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    @Override
    protected void associar(Aula aula) {
        aula.setProfessor(this);
    }


    //------------


    @Override
    protected void dessociar(Aula aula) {
        aula.desassociarProfessor();
    }
}
