package ar.com.tbi.service.eventoGastronomico.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

import ar.com.tbi.domain.EventoGastronomico;
import ar.com.tbi.domain.Participante;
import ar.com.tbi.service.eventoGastronomico.EventoGastronomicoService;
import ar.com.tbi.service.organizacion.OrganizacionService;
import ar.com.tbi.service.participante.ParticipanteService;


public class EventoGastronomicoServiceImpl implements EventoGastronomicoService {

    private final OrganizacionService organizacionService;
    private final List<EventoGastronomico> eventos = new ArrayList<>();

    public EventoGastronomicoServiceImpl(ParticipanteService participanteService, OrganizacionService organizacionService) {
        this.organizacionService = organizacionService;
    }
    
    @Override
    public EventoGastronomico crearEventoGastronomico() {
        EventoGastronomico nuevoEventoGastronomico = new EventoGastronomico();
        Scanner sc = new Scanner(System.in);

        nuevoEventoGastronomico.setIdEvento(UUID.randomUUID());
    
        System.out.println("Ingrese el nombre del evento gastronomico: ");
        String nombreEventoGastronomico = sc.nextLine();
        nuevoEventoGastronomico.setNombre(nombreEventoGastronomico);
        System.out.println("Ingrese la descripcion del evento: ");
        String descripcionEventoGastronomico = sc.nextLine();
        nuevoEventoGastronomico.setDescripcion(descripcionEventoGastronomico);
        
        boolean fechaValida = false;
        while (!fechaValida) {
            System.out.println("Ingrese la fecha y hora en la que se realizará el evento (dd/MM/yyyy HH:mm): ");
            String fecha = sc.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime fechaYHoraEventoGastronomico = LocalDateTime.parse(fecha, formatter);
                nuevoEventoGastronomico.setFechaYHora(fechaYHoraEventoGastronomico);
                fechaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha y hora inválidas. Por favor, ingrese una fecha y hora en el formato dd/MM/yyyy HH:mm.");
            }
        }
        
        System.out.println("Ingrese la ubicación del evento: ");
        String ubicacionEventoGastronomico = sc.nextLine();
        nuevoEventoGastronomico.setUbicacion(ubicacionEventoGastronomico);
        
        System.out.println("Ingrese la capacidad maxima de participantes para este evento: ");
        Double capacidadMax = sc.nextDouble();
        nuevoEventoGastronomico.setCapacidadMax(capacidadMax);
        
        organizacionService.getEventoGastronomico().add(nuevoEventoGastronomico);
        System.out.println("Evento creado satisfactoriamente \n El ID del evento es:" + nuevoEventoGastronomico.getIdEvento());
        return nuevoEventoGastronomico;
    }
   

    @Override
    public void registrarParticipante(UUID idEvento, Participante participante) {
    boolean existeEventoGastronomico = Boolean.FALSE;
    for (EventoGastronomico evento : organizacionService.getEventoGastronomico()) {
        if (evento.getIdEvento().equals(idEvento)) {
            evento.getParticipantes().put(participante.getDni(),participante);
            existeEventoGastronomico = Boolean.TRUE;
            break;
        }
    }
    if (existeEventoGastronomico) {
        System.out.println("Participante asignado al evento");
    }
    }

    @Override
    public void inscribirParticipanteAEventoGastronomico(UUID idEvento, Long dni) {
        Participante participante = null;
        boolean existeElParticipante = Boolean.FALSE;
        boolean esEventoGastronomicoEncontrado = Boolean.FALSE;

        for (EventoGastronomico evento: organizacionService.getEventoGastronomico()){
            if (evento.getParticipantes().containsKey(dni)){
                participante = evento.getParticipantes().get(dni);
                existeElParticipante = Boolean.TRUE;
                break;
            }
        }
        if (!existeElParticipante){
            throw new NoSuchElementException("No existe el participante");
        }

        for (EventoGastronomico evento: organizacionService.getEventoGastronomico()){
            if (evento.getIdEvento().equals(idEvento)){
                participante.getEventosConcurridos().add(evento);
                evento.getParticipantes().put(participante.getDni(), participante);
                esEventoGastronomicoEncontrado = Boolean.TRUE;
                break;
            }
        }
        if (!esEventoGastronomicoEncontrado){
            throw new NoSuchElementException("No existe el evento gastronómico");
        }else {
            System.out.println("Participante asignado al evento");
        }
    }

    
    @Override
    public EventoGastronomico buscarEventoPorId(UUID idEvento) {
        for (EventoGastronomico evento :organizacionService.getEventoGastronomico()) {
            if (evento.getIdEvento().equals(idEvento)) {
                return evento;
            }
        }
        return null;
    }

    @Override
    public List<EventoGastronomico> listarEventosDisponibles(LocalDateTime fechaYHora) {
        List<EventoGastronomico> eventosDisponibles = new ArrayList<>();
        for (EventoGastronomico evento : eventosDisponibles) {
            if (evento.getFechaYHora().equals(fechaYHora) && 
                evento.getParticipantes().size() < evento.getCapacidadMax()) {
                eventosDisponibles.add(evento);
            }
        }
        return eventosDisponibles;
    }

    @Override
    public void listarParticipantesYEventosConcurridos() {
        Set<Participante> listaParticipanteSinRepetir = new HashSet<>();
        
        for (EventoGastronomico evento : organizacionService.getEventoGastronomico()) {
            listaParticipanteSinRepetir.addAll(evento.getParticipantes().values());
        }
        System.out.println("Participantes y eventos: ");
        for (Participante participante : listaParticipanteSinRepetir) {
            System.out.println("Participantes: " + participante.toString());
            System.out.println("Eventos que participa: ");
            for (EventoGastronomico evento: participante.getEventosConcurridos()) {
                System.out.println(evento.toString());
            }
        }
    }

    @Override
    public List<EventoGastronomico> getEventoGastronomico() {
        return eventos;
    }

}
