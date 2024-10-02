package ar.com.tbi.domain;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class EventoGastronomico {
    private UUID idEvento;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaYHora;
    private String ubicacion;
    private Double capacidadMax;
    private Chef nombreChefAcargo;

    private Map<Long,Participante> participantes = new TreeMap<>();

    public EventoGastronomico(UUID idEvento, String nombre, String descripcion, LocalDateTime fechaYHora, String ubicacion, Double capacidadMax, Chef nombreChefAcargo) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaYHora = fechaYHora;
        this.ubicacion = ubicacion;
        this.capacidadMax = capacidadMax;
        this.nombreChefAcargo = nombreChefAcargo;

        this.participantes = new TreeMap<>();
    }

    public EventoGastronomico() {}

    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(UUID id) {
        this.idEvento = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }   

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(Double capacidadMax) {
        this.capacidadMax = capacidadMax;
    }
    
    
    public Map<Long, Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Map<Long, Participante> participantes) {
        this.participantes = participantes;
    }
    
    public Chef getNombreChefAcargo() {
        return nombreChefAcargo;
    }

    public void setNombreChefAcargo(Chef nombreChefAcargo) {
        this.nombreChefAcargo = nombreChefAcargo;
    }
    

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Id : ")
                .append(this.getIdEvento()).append("\n")
                .append("Nombre : ")
                .append(this.getNombre()).append("\n")
                .append("Descripcion : ")
                .append(this.getDescripcion()).append("\n")
                .append("Fecha y Hora : ")
                .append(this.getFechaYHora()).append("\n")
                .append("Ubicacion : ")
                .append(this.getUbicacion()).append("\n")
                .append("Capacidad : ")
                .append(this.getCapacidadMax()).append("\n")
                .append("Chef a cargo : ")
                .append(this.getNombreChefAcargo()).append("\n")
                .append("-------------------------------------------------------\n")
                .toString();

    }

}