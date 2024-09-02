package ar.com.tbi.service.archivos;

import java.util.List;

import ar.com.tbi.domain.EventoGastronomico;

public interface ArchivosEventoGastronomicoService {
    void exportarEventoGastronomicoCsv(List<EventoGastronomico> evento);

    void cerrarWriter();
}