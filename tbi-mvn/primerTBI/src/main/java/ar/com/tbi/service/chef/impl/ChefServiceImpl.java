package ar.com.tbi.service.chef.impl;

import java.util.Scanner;

import ar.com.tbi.domain.Chef;
import ar.com.tbi.enumeration.EspecialidadEnum;
import ar.com.tbi.service.chef.ChefService;

public class ChefServiceImpl implements ChefService {


    public ChefServiceImpl() {

    }
    
    @Override
    public Chef crearChef() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el dni del chef: ");
        Long dniChef = sc.nextLong();
        
        sc.nextLine();
        
        System.out.println("Ingrese el nombre y apellido del chef: ");
        String nombreChef = sc.nextLine();
        
        System.out.println("Ingrese la especialidad: ");
        System.out.println("1. ITALIANA");
        System.out.println("2. MEXICANA");
        System.out.println("3. VEGANA");
        System.out.println("4. VEGETARIANA");
        System.out.println("5. ASADO");
        int especialidad = sc.nextInt();
        
        EspecialidadEnum especialidadEnum = switch (especialidad) {
            case 1 -> EspecialidadEnum.ITALIANA;
            case 2 -> EspecialidadEnum.MEXICANA;
            case 3 -> EspecialidadEnum.VEGANA;
            case 4 -> EspecialidadEnum.VEGETARIANA;
            case 5 -> EspecialidadEnum.ASADO;
            default -> null;
        };
        
        Chef chefNuevo = new Chef(dniChef, nombreChef, especialidadEnum);
        
        System.out.println("Chef registrado ");
        
        return chefNuevo;
    }
}
