package modelo.divisoes;
import modelo.pessoas.Professor;

import java.util.LinkedList;

public class GabineteProfessor extends Divisao {
    private LinkedList<Professor> professores;

    public GabineteProfessor(String nome, boolean aberta) {
        super(nome, aberta);
        professores = new LinkedList<>();
    }

    public LinkedList<Professor> getProfessor() {
        return null; // todo get professor
    }

    public void adicionar(Professor professor){
        // todo adicionar professor
    }

    public void remover(Professor professor){
        // todo remover professor
    }
}
