package ar.com.tbi.service.participante.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.com.tbi.domain.Participante;
import ar.com.tbi.enumeration.InteresEnum;
import ar.com.tbi.service.eventoGastronomico.EventoGastronomicoService;
import ar.com.tbi.service.participante.ParticipanteService;

public class ParticipanteServiceImpl implements ParticipanteService {

    private final List<Participante> participantes = new ArrayList<>();

    public ParticipanteServiceImpl(EventoGastronomicoService eventoGastronomicoService) {
    }

    @Override
    public Participante inscribirParticipante() {
        Participante participanteNuevo = new Participante();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dni del participante: ");
        Long dni = sc.nextLong();
        participanteNuevo.setDni(dni);
        System.out.println("Ingrese el nombre y apellido del participante: ");
        String nombreApellidoParticipante = sc.nextLine();
        participanteNuevo.setNombreApellido(nombreApellidoParticipante);
        sc.nextLine();
        System.out.println("Ingrese el interes culinario: ");
        System.out.println("1. ITALIANA");
        System.out.println("2. MEXICANA");
        System.out.println("3. VEGANA");
        System.out.println("4. VEGETARIANA");
        System.out.println("5. ASADO");
        int interesCulinario = sc.nextInt();
        participanteNuevo.setInteresCulinario(switch (interesCulinario) {
            case 1 -> InteresEnum.ITALIANA;
            case 2 -> InteresEnum.MEXICANA;
            case 3 -> InteresEnum.VEGANA;
            case 4 -> InteresEnum.VEGETARIANA;
            case 5 -> InteresEnum.ASADO;
            default -> null;
        });
        participantes.add(participanteNuevo);
        System.out.println("Participante registrado");
        return participanteNuevo;
    }

    @Override
    public Participante buscarParticipantePorDni(Long dni) {
        for (Participante participante : participantes) {
            if (participante.getDni().equals(dni)) {
                return participante;
            }
        }
        return null;
    }
}