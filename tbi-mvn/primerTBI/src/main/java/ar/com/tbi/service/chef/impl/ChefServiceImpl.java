// package ar.com.tbi.service.chef.impl;

// import java.util.Scanner;

// import ar.com.tbi.domain.Chef;
// import ar.com.tbi.enumeration.EspecialidadEnum;
// import ar.com.tbi.service.chef.ChefService;
// import ar.com.tbi.service.eventoGastronomico.EventoGastronomicoService;

// public class ChefServiceImpl implements ChefService {

//     public ChefServiceImpl() {
//     }

//     @Override
//     public Chef crearChef() {
//         Chef chefNuevo = new Chef();
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Ingrese el dni del chef: ");
//         Long dniChef = sc.nextLong();
//         chefNuevo.setDniChef(dniChef);
//         sc.nextLine();
//         System.out.println("Ingrese el nombre y apellido del chef: ");
//         String nombreChef = sc.next();
//         chefNuevo.setNombreChef(nombreChef);
//         sc.nextLine();
//         System.out.println("Ingrese la especialidad: ");
//         System.out.println("1. ITALIANA");
//         System.out.println("2. MEXICANA");
//         System.out.println("3. VEGANA");
//         System.out.println("4. VEGETARIANA");
//         System.out.println("5. ASADO");
//         int especialidad = sc.nextInt();
//         chefNuevo.setEspecialidad(switch (especialidad) {
//             case 1 -> EspecialidadEnum.ITALIANA;
//             case 2 -> EspecialidadEnum.MEXICANA;
//             case 3 -> EspecialidadEnum.VEGANA;
//             case 4 -> EspecialidadEnum.VEGETARIANA;
//             case 5 -> EspecialidadEnum.ASADO;
//             default -> null;
//         });
        
//         System.out.println("Chef registrado ");
//         return chefNuevo;
//     }

        // @Override
    // public void crearChef(EventoGastronomico eventoGastronomico) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Ingrese el DNI del chef:");
    //     Integer dniChef = sc.nextInt();
    //     System.out.println("Ingrese el nombre del chef:");
    //     String nombre = sc.next();
    //     System.out.println("Ingrese la especialidad del chef (ITALIANA, MEXICANA, VEGANA, VEGETARIANA, ASADO):");
    //     String especialidad = sc.next().toUpperCase();
    //     EspecialidadEnum especialidadEnum = EspecialidadEnum.valueOf(especialidad);
    //     Chef nuevoChef = new Chef(dniChef, nombre, especialidadEnum);
    //     nuevoChef.getEventoParticipa().add(eventoGastronomico);
    //     System.out.println("Chef registrado y agregado al evento con éxito!");
    // }
// }
