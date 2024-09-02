package ar.com.tbi.service.participante;

import ar.com.tbi.domain.Participante;

public interface ParticipanteService {

    Participante inscribirParticipante();
    Participante buscarParticipantePorDni(Long dni);

    
}