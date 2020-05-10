package modelo.pessoas;

import modelo.Aula;

public class Aluno  extends PessoaComAulas {


    // Contructor
    public Aluno(String nome, long numero) {
        super(nome, numero);

    }



    @Override
    protected void associar(Aula aula) {
        aula.adicionar(this);
    }

    //--------------------




    @Override
    protected void escreverSumario(Aula aula) {
      super.assinarSumario(aula);
    }

    @Override
    protected void dessociar(Aula aula) {
        aula.remover(this);

    }
}