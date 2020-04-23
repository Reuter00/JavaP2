package modelo;

public class Horario {
    private DiaSemana diaSemana;
    private int horaInicio;
    private int duracao;

    //Constructor
    public Horario(DiaSemana diaSemana, int horaInicio, int duracao) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isSobre(Horario horario) {
        int horaInicio1 = this.horaInicio;
        int horaFim1 = this.horaInicio + this.duracao;
        int horaInicio2 = horario.horaInicio;
        int horaFim2 = horario.horaInicio + horario.duracao;

        return this.diaSemana == horario.diaSemana &&
                horaFim2 > horaInicio1 && horaInicio2 < horaFim1;

      /*  if (this.diaSemana != horario.diaSemana) {
            return false;
        } else { //confirma que é a mesma semana

            if (horaFim2 <= horaInicio1 || horaInicio2 >= horaFim1) {
                return false;
            }

            return true; */


        }
    }


