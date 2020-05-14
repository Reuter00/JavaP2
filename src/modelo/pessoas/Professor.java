package modelo.pessoas;

import modelo.divisoes.GabineteSeguranca;
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
       if (gabinete!= null && !gabinete.isAberta()){
           gabinete.abrir();
       }
    }

    public void fecharGabinete(){
        if (gabinete!= null && gabinete.isAberta()){
            gabinete.fechar();
        }
    }

    public void abrir(Sala sala){
        if (sala != null && !sala.isAberta()){
            sala.abrir();
        }
    }


    public void fechar(Sala sala){
        if (sala != null && sala.isAberta()){
            sala.fechar();
        }
    }

    public void setGabinete(GabineteProfessor gabinete){
        if(gabinete==null || this.gabinete == gabinete) {
            return;
        }
        desassociarGabinete();
        this.gabinete = gabinete;
        gabinete.adicionar(this);
    }

    public void desassociarGabinete(){
      if (this.gabinete == null){
          return;
      }

        GabineteProfessor gabineteARemover = gabinete;
        this.gabinete = null;
        this.gabinete.remover(this);
    }

    public void adicionar(Horario horario) {
        if (horario == null || horariosAtendimento.contains(horario)){
            return;
        }
        horariosAtendimento.add(horario);
    }

    public void remover(Horario horario) {
        if (horario != null){
            horariosAtendimento.remove(horario);
        }
    }



}
