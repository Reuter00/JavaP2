package modelo;
import java.util.LinkedList;

public class Professor {
    private String nome;
    private long numero;
    private LinkedList<Aula> aulas;

    public Professor(String nome, long numero){
        this.nome=nome;
        this.numero=numero;
        this.aulas=new LinkedList<>();
    }


    //Dados do Professor
    public String getNome(){
        return this.nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
    //------------

    public void preencherSumario(Aula aula){
        if (!aulas.contains(aula) || !aula.getSumario().isEmpty()) { return; } // Verifica se o professor tem a aula e se o sumario não esta vazio
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(this.nome);
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
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

    //Adicionar ou remover Aula
    public void adicionar(Aula aula){
        if(aula==null || aulas.contains(aula)){
            return;
        }
        aulas.add(aula);
        aula.setProfessor(this);
    }

    public void remover(Aula aula){
        if(!aulas.contains(aula)){
            return;
        }
        aulas.remove(aula);
        aula.desassociarProfessor();
    }
    //------------

}
