package ar.com.tbi.service.resena.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import ar.com.tbi.domain.EventoGastronomico;
import ar.com.tbi.domain.Participante;
import ar.com.tbi.domain.Resena;
import ar.com.tbi.service.resena.ResenaService;

public class ResenaServiceImpl implements ResenaService {

    private final List<Resena> resenas = new ArrayList<>();
    private final List<EventoGastronomico> eventos = new ArrayList<>();
        
    @Override
    public Resena dejarResena(Participante participante, EventoGastronomico eventoGastronomico) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el ID del evento: ");
        String idEvento1 = sc.next();
        
        EventoGastronomico evento = buscarEventoPorId(idEvento1);
        
        if (evento == null) {
            System.out.println("Evento no encontrado");
            return null;
        }
        
        System.out.println("Ingrese la calificación del evento (1-5): ");
        Double calificacion = sc.nextDouble();
        while (calificacion < 1 || calificacion > 5) {
            System.out.println("La calificación debe ser entre 1 y 5. Ingrese nuevamente: ");
            calificacion = sc.nextDouble();
        }
        
        sc.nextLine(); 
        System.out.println("Ingrese el comentario: ");
        String comentario = sc.nextLine();
        while (comentario.trim().isEmpty()) {
            System.out.println("El comentario no puede estar vacío. Ingrese nuevamente: ");
            comentario = sc.nextLine();
        }
        
        Resena resena = new Resena(UUID.randomUUID(), evento, participante, calificacion, comentario);
        resenas.add(resena);
        sc.close();
          
        System.out.println("Resena ingresada con éxito!");
        return resena;
    }
    

    private EventoGastronomico buscarEventoPorId(String idEvento1) {
        for (EventoGastronomico evento : eventos) {
            if (evento.getIdEvento().equals(UUID.fromString(idEvento1))) {
                return evento;
            }
        }
        return null;
    }
}
