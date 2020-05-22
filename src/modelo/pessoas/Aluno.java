package modelo.pessoas;

import modelo.Aula;

public class Aluno  extends PessoaComAulas {


    // Contructor
    public Aluno(String nome, long numero) {
        super(nome, numero);

    }


    //--------------------
    @Override
    public void associar(Aula aula) {
        aula.adicionar(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.remover(this);

    }



    @Override
    protected void escreverSumario(Aula aula) {
      super.assinarSumario(aula);
    }


}