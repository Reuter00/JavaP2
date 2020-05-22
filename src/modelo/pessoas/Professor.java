package modelo.pessoas;

import modelo.divisoes.GabineteSeguranca;
import modelo.divisoes.Sala;
import modelo.Aula;
import modelo.Horario;
import modelo.divisoes.GabineteProfessor;


import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario<GabineteProfessor, Sala> {

    private GabineteProfessor gabinete;
    private GestorFuncionario gestorFuncionario;

    public Professor(String nome, long numero, GabineteProfessor gabinete){
        super(nome,numero);
        gestorFuncionario = new GestorFuncionario();
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

    public GabineteProfessor getGabinete() {
        return gabinete;
    }

    @Override
    public LinkedList<Horario> getHorariosAtendimento() {
        return gestorFuncionario.getHorariosAtendimento(); // passar por parametero para copiar a lista e não isar uma original
    }

    @Override
    public void abrirGabinete(){
       if (gabinete!= null && !gabinete.isAberta()){
           gabinete.abrir();
       }
    }

    @Override
    public void fecharGabinete(){
        if (gabinete!= null && gabinete.isAberta()){
            gabinete.fechar();
        }
    }

    @Override
    public void abrir(Sala sala){
        if (sala != null && !sala.isAberta()){
            sala.abrir();
        }
    }

    @Override
    public void fechar(Sala sala){
        if (sala != null && sala.isAberta()){
            sala.fechar();
        }
    }

    @Override
    public void setGabinete(GabineteProfessor gabinete){
        if(gabinete==null || this.gabinete == gabinete) {
            return;
        }
        desassociarGabinete();
        this.gabinete = gabinete;
        gabinete.adicionar(this);
    }

    @Override
    public void desassociarGabinete(){
      if (this.gabinete == null){
          return;
      }

        GabineteProfessor gabineteARemover = gabinete;
        this.gabinete = null;
        this.gabinete.remover(this);
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
