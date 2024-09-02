package ar.com.tbi.domain;

import java.util.*;

public class Resena {
    private UUID idResena;
    private EventoGastronomico evento;
    private Participante participante;
    private Double calificacion;
    private String comentario;

    public Resena(UUID idResena, EventoGastronomico evento, Participante participante, Double calificacion, String comentario){
        this.idResena = idResena;
        this.evento = evento;
        this.participante = participante;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public UUID getIdResena() {
        return idResena;
    }

    public void setIdResena(UUID idResena) {
        this.idResena = idResena;
    }

    public EventoGastronomico getEvento() {
        return evento;
    }

    public void setEvento(EventoGastronomico evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ID : ")
                .append(this.getIdResena()).append("\n")
                .append("ID Evento : ")
                .append(this.getEvento()).append("\n")
                .append("DNI Participante : ")
                .append(this.getParticipante()).append("\n")
                .append("Calificacion : ")
                .append(this.getCalificacion()).append("\n")
                .append("Comentario : ")
                .append(this.getComentario()).append("\n")
                .append("-------------------------------------------------------\n")
                .toString();
    }

}
