package ar.com.tbi.domain;
import java.util.*;

public class Organizacion {
    private List<EventoGastronomico> eventos = new ArrayList<>();

    public List<EventoGastronomico> getEventoGastronomico() {
        return eventos;
    }

    public void setEventoGastronomico(List<EventoGastronomico> evento) {
        this.eventos = evento;
    }

    public List<EventoGastronomico> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoGastronomico> eventos) {
        this.eventos = eventos;
    }
}