package modelo.pessoas;

import modelo.Gabinete;
import modelo.Horario;
import modelo.divisoes.Divisao;
import modelo.divisoes.GabineteProfessor;
import modelo.divisoes.GabineteSeguranca;
import modelo.divisoes.Sala;

import java.util.LinkedList;

public class GestorFuncionario<TGabinete extends Gabinete, TDivisao extends Divisao> {

    private TGabinete gabinete;
    private LinkedList<Horario> horariosAtendimento;
    private Funcionario<TGabinete,TDivisao> funcionario;

    public GestorFuncionario(Funcionario<TGabinete,TDivisao> funcionario){
        horariosAtendimento = new LinkedList<>();
        this.funcionario = funcionario;
    }


    public LinkedList<Horario> getHorariosAtendimento() {
        return new LinkedList<>(horariosAtendimento); // passar por parametero para copiar a lista e não isar uma original
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

    public TGabinete getGabinete() {
        return gabinete;
    }

    public void setGabinete(TGabinete gabinete){
        if(gabinete==null || this.gabinete == gabinete) {
            return;
        }
        desassociarGabinete();
        this.gabinete = gabinete;
        gabinete.adicionar(funcionario);
    }


    public void desassociarGabinete(){
        if (this.gabinete == null){
            return;
        }

        TGabinete gabineteARemover = gabinete;
        this.gabinete = null;
        this.gabinete.remover(funcionario);
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

    public void abrir(TDivisao divisao){
        if (divisao != null && !divisao.isAberta()){
            divisao.abrir();
        }
    }


    public void fechar(TDivisao divisao){
        if (divisao != null && divisao.isAberta()){
            divisao.fechar();
        }
    }
}
