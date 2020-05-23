package modelo.pessoas;

import modelo.divisoes.GabineteSeguranca;
import modelo.divisoes.Sala;
import modelo.Aula;
import modelo.Horario;
import modelo.divisoes.GabineteProfessor;


import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario<GabineteProfessor, Sala> {


    private GestorFuncionario<GabineteProfessor, Sala> gestorFuncionario;

    public Professor(String nome, long numero, GabineteProfessor gabinete){
        super(nome,numero);
        gestorFuncionario = new GestorFuncionario<>(this);
        setGabinete(gabinete);
    }

@Override
public void preencherSumario(Aula aula){
        if (!aula.getSumario().isEmpty()){
            return;
        }
        super.preencherSumario(aula);
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
    public void associar(Aula aula) {
        aula.setProfessor(this);
    }

    @Override
    public void desassociar(Aula aula) {
        aula.desassociarProfessor();
    }

    @Override
    protected void assinarSumario(Aula aula) {
        super.assinarSumario(aula);
    }

    @Override
    public GabineteProfessor getGabinete() {
        return gestorFuncionario.getGabinete();
    }

    @Override
    public LinkedList<Horario> getHorariosAtendimento() {
        return gestorFuncionario.getHorariosAtendimento(); // passar por parametero para copiar a lista e não isar uma original
    }

    @Override
    public void abrirGabinete(){
     gestorFuncionario.abrirGabinete();
    }

    @Override
    public void fecharGabinete(){
       gestorFuncionario.fecharGabinete();
    }

    @Override
    public void abrir(Sala sala){
       gestorFuncionario.abrir(sala);
    }

    @Override
    public void fechar(Sala sala){
        gestorFuncionario.fechar(sala);
    }

    @Override
    public void setGabinete(GabineteProfessor gabinete){
       gestorFuncionario.setGabinete(gabinete);
    }

    @Override
    public void desassociarGabinete(){
      gestorFuncionario.desassociarGabinete();
    }

    @Override
    public void adicionar(Horario horario) {
        gestorFuncionario.adicionar(horario);
    }

    @Override
    public void remover(Horario horario) {
        gestorFuncionario.remover(horario);
    }



}
