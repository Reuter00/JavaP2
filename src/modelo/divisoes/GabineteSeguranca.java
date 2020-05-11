package modelo.divisoes;
import modelo.pessoas.Professor;
import modelo.pessoas.Seguranca;

import java.util.LinkedList;

public class GabineteSeguranca extends Divisao {
    private LinkedList<Seguranca> segurancas;

    public GabineteSeguranca(String nome, boolean aberta) {
        super(nome, aberta);
        segurancas = new LinkedList<>();
    }

    public LinkedList<Seguranca> getSeguranca() {
        return new LinkedList<Seguranca>();
    }

    public void adicionar(Seguranca seguranca){
        // todo adicionar Seguranca
    }

    public void remover(Seguranca seguranca){
            // todo remover Seguranca
    }
}

