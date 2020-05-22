package modelo.pessoas;

import modelo.Horario;
import modelo.divisoes.Divisao;
import modelo.divisoes.GabineteProfessor;
import modelo.divisoes.GabineteSeguranca;

import java.util.LinkedList;

public class Seguranca extends Pessoa implements Funcionario {
    private GabineteSeguranca gabinete;
    private GestorFuncionario gestorFuncionario;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete) {
        super(nome, numero);
        setGabinete(gabinete);
        gestorFuncionario = new GestorFuncionario();

    }

    public LinkedList<Horario> getHorariosAtendimento() {
        return gestorFuncionario.getHorariosAtendimento(); // passar por parametero para copiar a lista e não isar uma original
    }

    public void adicionar(Horario horario) {
        gestorFuncionario.adicionar(horario);
    }

    public void remover(Horario horario) {
        gestorFuncionario.remover(horario);
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
