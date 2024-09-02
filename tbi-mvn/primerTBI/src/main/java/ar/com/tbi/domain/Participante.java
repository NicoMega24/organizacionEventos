package ar.com.tbi.domain;

import java.util.*;

import ar.com.tbi.enumeration.InteresEnum;

public class Participante {
    private Long dni;
    private String nombreApellido;
    private InteresEnum interesCulinario;

    private List<EventoGastronomico> eventosConcurridos = new ArrayList<>();

    public Participante(Long dni, String nombreApellido, InteresEnum interesCulinario) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.interesCulinario = interesCulinario;
        
        this.eventosConcurridos = new ArrayList<>();
    }

    public Participante() {
        
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public InteresEnum getInteresCulinario() {
        return interesCulinario;
    }

    public void setInteresCulinario(InteresEnum interesCulinario) {
        this.interesCulinario = interesCulinario;
    }

    public List<EventoGastronomico> getEventosConcurridos() {
        return eventosConcurridos;
    }

    public void setEventosConcurridos(List<EventoGastronomico> eventosConcurridos) {
        this.eventosConcurridos = eventosConcurridos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Dni : ")
                .append(this.getDni()).append("\n")
                .append("Nombre y Apellido : ")
                .append(this.getNombreApellido()).append("\n")
                .append("Interes culinario : ")
                .append(this.getInteresCulinario()).append("\n")
                .append("Eventos concurridos : ")
                .append(this.getEventosConcurridos()).append("\n")
                .append("-------------------------------------------------------\n")
                .toString();
    }

    @Override
    public boolean equals(Object obj) {

        if(super.equals(obj)){
            return true;
        }

        if (obj instanceof Participante){
            Participante participante = (Participante) obj;
            return this.dni == participante.getDni().longValue() && this.getNombreApellido().equals(participante.getNombreApellido());
        }
        return false;
    }

    @Override
    public int hashCode() {

        int hash = 10;

        hash = hash + 155 * this.dni.hashCode();
        hash = hash + 155 * this.getNombreApellido().length();
        return hash * 10;
    }


}