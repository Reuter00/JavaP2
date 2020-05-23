package modelo.pessoas;

import modelo.Horario;
import modelo.divisoes.Divisao;
import modelo.divisoes.GabineteProfessor;
import modelo.divisoes.GabineteSeguranca;
import modelo.divisoes.Sala;

import java.util.LinkedList;

public class Seguranca extends Pessoa implements Funcionario<GabineteSeguranca, Divisao> {
    private GestorFuncionario<GabineteSeguranca, Divisao> gestorFuncionario;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete) {
        super(nome, numero);
        gestorFuncionario = new GestorFuncionario<>(this);
        setGabinete(gabinete);

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
      gestorFuncionario.abrirGabinete();
    }

    public void fecharGabinete() {
      gestorFuncionario.fecharGabinete();
    }

    @Override
    public void abrir(Divisao divisao) {
        if (divisao != null &&  !divisao.isAberta()){
            divisao.abrir();
        }
    }

    @Override
    public void fechar(Divisao divisao) {
        if (divisao != null && divisao.isAberta()){
            divisao.fechar();
        }
    }

    @Override
    public GabineteSeguranca getGabinete() {
        return gestorFuncionario.getGabinete();
    }

    @Override
    public void setGabinete(GabineteSeguranca gabinete){
        gestorFuncionario.setGabinete(gabinete);
    }

    public void desassociarGabinete() {
        gestorFuncionario.desassociarGabinete();
    }
}
