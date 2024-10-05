package ar.com.tbi;

import java.util.Scanner;

import ar.com.tbi.domain.Organizacion;
import ar.com.tbi.service.archivos.ArchivosEventoGastronomicoService;
import ar.com.tbi.service.archivos.impl.ArchivosEventoGastronomicoServiceImpl;
import ar.com.tbi.service.chef.ChefService;
import ar.com.tbi.service.chef.impl.ChefServiceImpl;
import ar.com.tbi.service.eventoGastronomico.EventoGastronomicoService;
import ar.com.tbi.service.eventoGastronomico.impl.EventoGastronomicoServiceImpl;
import ar.com.tbi.service.menu.MenuService;
import ar.com.tbi.service.menu.impl.MenuServiceImpl;
import ar.com.tbi.service.organizacion.OrganizacionService;
import ar.com.tbi.service.organizacion.impl.OrganizacionServiceImpl;
import ar.com.tbi.service.participante.ParticipanteService;
import ar.com.tbi.service.participante.impl.ParticipanteServiceImpl;
import ar.com.tbi.service.resena.ResenaService;
import ar.com.tbi.service.resena.impl.ResenaServiceImpl;



public class App {
    public static void main(String[] args) {
        Organizacion organizacion = new Organizacion();
        OrganizacionService organizacionService = new OrganizacionServiceImpl(organizacion);
        ParticipanteService participanteService = new ParticipanteServiceImpl(null);
        ArchivosEventoGastronomicoService archivosEventoGastronomicoService = new ArchivosEventoGastronomicoServiceImpl();
        EventoGastronomicoService eventoGastronomicoService = new EventoGastronomicoServiceImpl(participanteService, organizacionService);
        ResenaService resenaService = new ResenaServiceImpl();
        ChefService chefService = new ChefServiceImpl();
        MenuService menuService = new MenuServiceImpl(eventoGastronomicoService, archivosEventoGastronomicoService, participanteService, chefService, resenaService);

        try (Scanner scanner = new Scanner(System.in)) {
            menuService.mostrarMenu(scanner);
        } finally {
            archivosEventoGastronomicoService.cerrarWriter();
        }
    }
}
