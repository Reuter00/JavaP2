package modelo.divisoes;
import modelo.Aula;
import modelo.Horario;
import modelo.pessoas.Aluno;

import java.util.LinkedList;

public class Sala  extends Divisao{
    private LinkedList<Aula> aulas;

    public Sala(String nome,boolean aberta) {
        super(nome, aberta);
        aulas = new LinkedList<>();
    }

    public LinkedList<Aula> getAulas(){
        return new LinkedList<>(aulas); // todo get aulas
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

    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }

    public void remover(Aula aula){
        if (aulas.remove(aula)){
            aula.remover(aula);
        }

    }
    public void adicioar(Aula aula){
        // todo adicionar aula
    }

    public void remover(Aula aula){
        // todo remover aula
    }
}
