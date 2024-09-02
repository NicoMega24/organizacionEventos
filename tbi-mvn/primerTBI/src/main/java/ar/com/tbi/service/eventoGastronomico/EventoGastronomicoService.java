package ar.com.tbi.service.eventoGastronomico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import ar.com.tbi.domain.EventoGastronomico;
import ar.com.tbi.domain.Participante;

public interface EventoGastronomicoService {
    
    EventoGastronomico crearEventoGastronomico();
    
    void registrarParticipante(UUID idEvento, Participante participante);

    void inscribirParticipanteAEventoGastronomico(UUID idEvento, Long dni);

    List<EventoGastronomico> listarEventosDisponibles(LocalDateTime fecha);
    
    void listarParticipantesYEventosConcurridos();

    void crearChef(EventoGastronomico eventoGastronomico);
    
    void dejarResena(EventoGastronomico evento, Participante participante);

    EventoGastronomico buscarEventoPorId(UUID idEvento);

    List<EventoGastronomico> getEventoGastronomico();
}