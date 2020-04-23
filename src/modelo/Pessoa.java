package modelo;

import java.util.LinkedList;

public class Pessoa {


    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas); // Para prevenir que mexam na lista, cria se uma nova
    }

}
