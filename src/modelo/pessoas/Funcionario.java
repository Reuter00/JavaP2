package modelo.pessoas;

import modelo.Gabinete;
import modelo.Horario;
import modelo.divisoes.Divisao;
import modelo.divisoes.GabineteProfessor;

import java.util.LinkedList;

public interface Funcionario<TGabinete extends Gabinete, TDivisao extends Divisao> {
    LinkedList<Horario> getHorariosAtendimento();

    void abrirGabinete();

    void fecharGabinete();

    void desassociarGabinete();

    void adicionar(Horario horario);

    void remover(Horario horario);

    TGabinete getGabinete();
    void setGabinete(TGabinete gabinete);
    void abrir(TDivisao divisao);
    void fechar(TDivisao divisao);

}
