package ar.com.tbi.service.menu.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

import ar.com.tbi.bd.BdEventoGastronomico;
import ar.com.tbi.domain.EventoGastronomico;
import ar.com.tbi.domain.Participante;
import ar.com.tbi.service.archivos.ArchivosEventoGastronomicoService;
import ar.com.tbi.service.eventoGastronomico.EventoGastronomicoService;
import ar.com.tbi.service.menu.MenuService;
import ar.com.tbi.service.participante.ParticipanteService;

public class MenuServiceImpl implements MenuService {

    private EventoGastronomicoService eventoService;
    private ArchivosEventoGastronomicoService archivosEventoGastronomicoService;
    private ParticipanteService participanteService;

    public MenuServiceImpl(EventoGastronomicoService eventoService, ArchivosEventoGastronomicoService archivosEventoGastronomicoService, ParticipanteService participanteService) {
        this.eventoService = eventoService;
        this.archivosEventoGastronomicoService = archivosEventoGastronomicoService;
        this.participanteService = participanteService;
    }

    @Override
    public void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("----------------------------- MENU ---------------------------------");
            System.out.println("Ingrese opción: ");
            System.out.println("1. Crear evento gastronomico");
            System.out.println("2. Inscribir participante nuevo");
            System.out.println("3. Registrar participante a un evento disponible");
            System.out.println("4. Registrar chef y asignarlo a un evento disponible");
            System.out.println("5. Dejar una reseña al evento concurrido");
            System.out.println("6. Listar eventos disponibles a partir de una fecha");
            System.out.println("7. Exportar eventos a desarrollarse, que no tengan mas capacidad");
            System.out.println("8. Salir");
            System.out.println("---------------------------------------------------------------------");

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    eventoService.crearEventoGastronomico();
                    break;
                case 2:
                    participanteService.inscribirParticipante();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del evento gastronómico: ");
                    UUID idEvento = UUID.fromString(scanner.next());
                    System.out.print("Ingrese el DNI del participante: ");
                    Long dni = scanner.nextLong();
                    try {
                        eventoService.inscribirParticipanteAEventoGastronomico(idEvento, dni);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el ID del evento gastronómico: ");
                    UUID idEvento2 = UUID.fromString(scanner.next());
                    EventoGastronomico eventoGastronomico = eventoService.buscarEventoPorId(idEvento2);
                    if (eventoGastronomico != null) {
                        eventoService.crearChef(eventoGastronomico);
                        System.out.println("Chef creado y agregado a Evento");
                    } else {
                        System.out.println("Evento gastronómico no encontrado");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el ID del evento gastronómico: ");
                    UUID idEvento3 = UUID.fromString(scanner.next());
                    EventoGastronomico evento = eventoService.buscarEventoPorId(idEvento3);
                    if (evento != null) {
                        System.out.print("Ingrese el DNI del participante: ");
                        Long dniParticipante = scanner.nextLong();
                        Participante participante = participanteService.buscarParticipantePorDni(dniParticipante);
                        if (participante != null) {
                            eventoService.dejarResena(evento, participante);
                        } else {
                            System.out.println("Participante no encontrado");
                        }
                    } else {
                        System.out.println("Evento gastronómico no encontrado");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese la fecha (dd/MM/yyyy): ");
                    String fechaString = scanner.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(fechaString, formatter);
                    LocalDateTime fechaYHora = fecha.atStartOfDay();
                    List<EventoGastronomico> eventosDisponibles = eventoService.listarEventosDisponibles(fechaYHora);
                    if (eventosDisponibles.isEmpty()) {
                        System.out.println("No hay eventos disponibles en esa fecha");
                    } else {
                        System.out.println("Eventos disponibles en " + fechaString + ":");
                        for (EventoGastronomico eventos : eventosDisponibles) {
                            System.out.println(eventosDisponibles);
                        }
                    }
                    break;
                case 7:
                    archivosEventoGastronomicoService.exportarEventoGastronomicoCsv(BdEventoGastronomico.getEventoList());                
                    break;
                case 8:
                    System.out.println("\n ------------ Aplicacion finalizada --------------");
                    break;
                default:
                    break;
            }
        } while (opcion != 8);
    }
}