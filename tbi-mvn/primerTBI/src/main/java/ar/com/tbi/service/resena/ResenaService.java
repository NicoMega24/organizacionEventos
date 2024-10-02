package ar.com.tbi.service.resena;

import ar.com.tbi.domain.EventoGastronomico;
import ar.com.tbi.domain.Participante;
import ar.com.tbi.domain.Resena;

public interface ResenaService {

    Resena dejarResena(Participante participante, EventoGastronomico eventoGastronomico);

}
