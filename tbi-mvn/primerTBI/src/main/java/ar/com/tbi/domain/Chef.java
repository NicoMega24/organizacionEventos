package ar.com.tbi.domain;

import java.util.ArrayList;
import java.util.List;

import ar.com.tbi.enumeration.EspecialidadEnum;

public class Chef {
    private Long dniChef;
    private String nombreChef;
    private EspecialidadEnum especialidad;

    private List<EventoGastronomico> eventoParticipa = new ArrayList<>();

    public Chef(Long dniChef, String nombre, EspecialidadEnum especialidad){
       this.dniChef = dniChef;
       this.nombreChef = nombre;
       this.especialidad = especialidad; 
    }

    public Long getDniChef() {
        return dniChef;
    }

    public void setDniChef(Long dniChef) {
        this.dniChef = dniChef;
    }

    public String getNombreChef() {
        return nombreChef;
    }

    public void setNombreChef(String nombreChef) {
        this.nombreChef = nombreChef;
    }

    public EspecialidadEnum getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadEnum especialidad) {
        this.especialidad = especialidad;
    }

    public List<EventoGastronomico> getEventoParticipa() {
        return eventoParticipa;
    }

    public void setEventoParticipa(List<EventoGastronomico> eventoParticipa) {
        this.eventoParticipa = eventoParticipa;
    }
        
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Dni : ")
                .append(this.getDniChef()).append("\n")
                .append("Nombre y Apellido : ")
                .append(this.getNombreChef()).append("\n")
                .append("Especialidad del chef : ")
                .append(this.getEspecialidad()).append("\n")
                .append("Eventos que participa : ")
                .append(this.getEventoParticipa()).append("\n")
                .append("-------------------------------------------------------\n")
                .toString();
    }

    @Override
    public boolean equals(Object obj) {

        if(super.equals(obj)){
            return true;
        }

        if (obj instanceof Chef){
            Chef chef = (Chef) obj;
            return this.dniChef == chef.getDniChef().longValue() && this.getNombreChef().equals(chef.getNombreChef());
        }
        return false;
    }

    @Override
    public int hashCode() {

        int hash = 10;

        hash = hash + 155 * this.dniChef.hashCode();
        hash = hash + 155 * this.getNombreChef().length();
        return hash * 10;
    }
}
