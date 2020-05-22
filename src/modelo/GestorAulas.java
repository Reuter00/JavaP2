package modelo;

import javax.swing.*;
import java.util.LinkedList;

public class GestorAulas {
    private LinkedList<Aula> aulas;
    private AssociavelAulas associavelAulas;

    public GestorAulas(AssociavelAulas associavelAulas){
        aulas = new LinkedList<>();
        this.associavelAulas = associavelAulas;
    }


    public LinkedList<Aula> getAulas(){
        return new LinkedList<>(aulas);
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
        associavelAulas.associar(aula);
    }

    public void remover(Aula aula){
        if (aula != null && aulas.remove(aula)){
            associavelAulas.desassociar(aula);
        }
    }

    public boolean contem(Aula aula){
        return aulas.contains(aula);
    }

}
