package modelo.pessoas;

import modelo.divisoes.Sala;
import modelo.Aula;
import modelo.Horario;
import modelo.divisoes.GabineteProfessor;

import java.util.LinkedList;

public class Professor extends PessoaComAulas {

    private GabineteProfessor gabinete;
    private LinkedList<Horario> horariosAtendimento;

    public Professor(String nome, long numero, GabineteProfessor gabinete){
        super(nome,numero);
        horariosAtendimento = new LinkedList<>();
        setGabinete(gabinete);
    }



    @Override
    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        super.assinarSumario(aula);
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    @Override
    protected void associar(Aula aula) {
        aula.setProfessor(this);
    }


    //------------


    @Override
    protected void dessociar(Aula aula) {
        aula.desassociarProfessor();
    }

    public GabineteProfessor getGabinete() {
        return gabinete;
    }

    public LinkedList<Horario> getHorariosAtendimento() {
        return new LinkedList<>(horariosAtendimento); // passar por parametero para copiar a lista e não isar uma original
    }

    public void abrirGabinete(){
       if (!gabinete.isAberta()){
           gabinete.abrir();
       }
    }

    public void fecharGabinete(){
        if (gabinete.isAberta()){
            gabinete.fechar();
        }
    }

    public void abrir(Sala sala){
        if (!sala.isAberta()){
            sala.abrir();
        }
    }


    public void fechar(Sala sala){
        if (sala.isAberta()){
            sala.fechar();
        }
    }

    public void setGabinete(GabineteProfessor gabinete){
        // todo implementar
    }

    public void desassociarGabinete(){
        // todo implementar
    }
    public void adicionar(Horario horario){
        // todo implementar
    }
    public void remover(Horario horario){
        // todo implementar
    }



}
