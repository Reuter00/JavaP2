package modelo.pessoas;

import modelo.*;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa implements RepositorioAulas, AssociavelAulas {

    private GestorAulas gestorAulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
       gestorAulas = new GestorAulas(this);
    }

    @Override
    public void adicionar(Aula aula) {
       gestorAulas.adicionar(aula);
    }

    @Override
    public void remover(Aula aula) {
        gestorAulas.remover(aula);
    }


    @Override
    public LinkedList<Aula> getAulas() {
        return gestorAulas.getAulas(); // Para prevenir que mexam na lista, cria se uma nova
    }
    @Override
    public LinkedList<Aula> getAulas(Horario horario) {
        return gestorAulas.getAulas(horario);
    }

    //Interface AssociavelAulas
   // public abstract void associar(Aula aula);
   // public abstract void dessociar(Aula aula);

    public void preencherSumario(Aula aula) {
        if (!gestorAulas.contem(aula)) {
            return;
        }
        escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    protected void assinarSumario(Aula aula){
        aula.adicionarLinhaSumario(this.nome);
    }


}