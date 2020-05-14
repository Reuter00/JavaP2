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
        return new LinkedList<Professor>();
    }

    public void adicionar(Professor professor){
        if(professor==null || professores.contains(professor)) {
            return;
        }
        professores.add(professor);
        professor.setGabinete(this);
    }

    public void remover(Professor professor){
        if ( professor != null && professores.remove(professor)){
            professor.desassociarGabinete();
        }
    }
}
