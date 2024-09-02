
package ar.com.tbi.service.organizacion.impl;

import ar.com.tbi.domain.EventoGastronomico;
import ar.com.tbi.domain.Organizacion;
import ar.com.tbi.service.organizacion.OrganizacionService;

import java.util.List;

public class OrganizacionServiceImpl implements OrganizacionService {

    Organizacion organizacion;

    public OrganizacionServiceImpl(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    @Override
    public List<EventoGastronomico> getEventoGastronomico() {
        return this.organizacion.getEventoGastronomico();
    }
}