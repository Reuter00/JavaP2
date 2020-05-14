package modelo.pessoas;

import modelo.Horario;
import modelo.divisoes.Divisao;
import modelo.divisoes.GabineteProfessor;
import modelo.divisoes.GabineteSeguranca;

import java.util.LinkedList;

public class Seguranca extends Pessoa {
    private GabineteSeguranca gabinete;
    private LinkedList<Horario> horariosAtendimento;
    private Divisao divisao;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete) {
        super(nome, numero);
        setGabinete(gabinete);
        horariosAtendimento = new LinkedList<>();
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

    public void abrirGabinete() {
        if (gabinete != null && !gabinete.isAberta()) {
            gabinete.abrir();
        }
    }

    public void fecharGabinete() {
        if (gabinete != null &&  gabinete.isAberta()) {
            gabinete.fechar();
        }
    }

    public void abrir(Divisao divisao) {
        if (divisao != null &&  !divisao.isAberta()){
            divisao.abrir();
        }
    }

    public void fechar(Divisao divisao) {
        if (divisao != null && divisao.isAberta()){
            divisao.fechar();
        }
    }

    public GabineteSeguranca getGabinete() {
        return gabinete;
    }

    public void setGabinete(GabineteSeguranca gabinete){
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
        GabineteSeguranca gabineteARemover = gabinete;
        this.gabinete = null;
        this.gabinete.remover(this);

    }

}
