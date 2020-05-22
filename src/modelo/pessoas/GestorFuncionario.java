package modelo.pessoas;

import modelo.Horario;

import java.util.LinkedList;

public class GestorFuncionario {
    private LinkedList<Horario> horariosAtendimento;

    public GestorFuncionario(){
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

}
