package com.company;

import modelo.*;
import modelo.pessoas.*;
import modelo.divisoes.*;
import java.util.LinkedList;

public class Main {

    public Main() {
        System.out.println();
        for (Aula aula : GestorSemanaAulas.INSTANCIA.getAulas()) {
            System.out.println(aula);
            System.out.println("\n----------------------------------------\n");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
