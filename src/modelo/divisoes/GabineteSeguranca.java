package modelo.divisoes;
import modelo.Gabinete;
import modelo.pessoas.Seguranca;

import java.util.LinkedList;

public class GabineteSeguranca extends Gabinete<Seguranca> {
    private LinkedList<Seguranca> segurancas;

    public GabineteSeguranca(String nome, boolean aberta) {
        super(nome, aberta);
        segurancas = new LinkedList<>();
    }


}

