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

    public ResenaServiceImpl() {
    }

    @Override
    public Resena dejarResena(EventoGastronomico evento, Participante participante) {
    Scanner sc = new Scanner(System.in);
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
    System.out.println("Resena ingresada con éxito!");
    return resena;
}
}
