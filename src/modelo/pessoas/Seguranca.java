package modelo.pessoas;

import modelo.Horario;
import modelo.divisoes.GabineteSeguranca;

import java.util.LinkedList;

public class Seguranca extends Pessoa {
    private GabineteSeguranca gabinete;
    private LinkedList<Horario> horariosAtendimento;

    public Seguranca(String nome, long numero, GabineteSeguranca gabinete) {
        super(nome, numero);
        setGabinete(gabinete);
        horariosAtendimento = new LinkedList<>();
    }

    public LinkedList<Horario> getHorariosAtendimento(){
        return null; // todo get horario atendimento
}

    public void adicionar(Horario horario){
            // todo adicionar horario
    }

    public void remover(Horario horario){
        // todo remover horario
    }

    public void abrirGabinete(){
            // todo abrir gabinete
    }

        public void fecharGabinete(){
            // todo fechar gabinete
        }

        public void abrir(Divisao divisao){
            // todo abrir divisao
        }

        public void fechar(Divisao divisao){
            // todo fechar divisao
        }

        public GabineteSeguranca getGabinete(){
            return gabinete;
        }

        public void setGabinete(GabineteSeguranca gabinete){
        // todo set gabinete
        }

        public void desassociarGabinete(){
        // todo desassociar gabinete
        }
}
