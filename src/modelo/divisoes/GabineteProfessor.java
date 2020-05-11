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
        if(professor==null || this.professores.contains(professor)) {
            return;
        }
        this.professores.add(professor);
        professor.a(this);
    }

    public void remover(Professor professor){
        // todo remover professor
    }
}
