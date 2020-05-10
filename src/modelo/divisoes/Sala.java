package modelo.divisoes;
import modelo.Aula;
import modelo.Horario;

import java.util.LinkedList;

public class Sala  extends Divisao{
    private LinkedList<Aula> aulas;

    public Sala(String nome,boolean aberta) {
        super(nome, aberta);
        aulas = new LinkedList<>();
    }

    public LinkedList<Aula> getAulas(){
        return null; // todo get aulas
    }

    public LinkedList<Aula> getAulas(Horario horario){
        return null; // todo get aulas (horario)
    }

    public void adicioar(Aula aula){
        // todo adicionar aula
    }

    public void remover(Aula aula){
        // todo remover aula
    }
}
