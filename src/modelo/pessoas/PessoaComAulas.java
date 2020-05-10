package modelo.pessoas;

import modelo.Aula;
import modelo.Horario;
import modelo.Identificador;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa {
    protected LinkedList<Aula> aulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
        this.aulas = new LinkedList<>();
    }

    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }

    protected abstract void associar(Aula aula);


    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas); // Para prevenir que mexam na lista, cria se uma nova
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasAux = new LinkedList<>();

        for (Aula aula : aulas) {
            if (aula.getHorario().isSobre(horario)) { // se os horarios estiverem sobrepostos
                aulasAux.add(aula);
            }
        }
        return aulasAux;
    }

    public void remover(Aula aula) {
        if (!aulas.remove(aula)) {
            return;
        }
        dessociar(aula);
    }

    protected abstract void dessociar(Aula aula);

    public void preencherSumario(Aula aula) {
        if (!aulas.contains(aula)) {
            return;
        }
        escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    protected void assinarSumario(Aula aula){
        aula.adicionarLinhaSumario(this.nome);
    }


}