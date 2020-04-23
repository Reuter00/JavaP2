package modelo;
import java.util.LinkedList;

public class Aluno  extends Identificador{
    private LinkedList<Aula> aulas;

    // Contructor
    public Aluno(String nome, long numero){
        super(nome, numero);
        this.aulas = new LinkedList<>();

    }

    //Adicionar ou remover Aula
    public void adicionar(Aula aula){
        if(aula == null || this.aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        aula.adicionar(this);

    }

    public void remover(Aula aula){
        if (aulas.remove(aula)) {
            aula.remover(this);
        }

    }
    //--------------------

    public void preencherSumario(Aula aula){
        if(!aulas.contains(aula)){
            return;
        }
        aula.adicionarLinhaSumario(this.nome);
    }

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

}