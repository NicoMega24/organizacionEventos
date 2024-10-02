package ar.com.tbi.service.archivos.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

import ar.com.tbi.domain.EventoGastronomico;
import ar.com.tbi.service.archivos.ArchivosEventoGastronomicoService;

public class ArchivosEventoGastronomicoServiceImpl implements ArchivosEventoGastronomicoService {
    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\ar\\com\\tbi\\recursos\\";

    CSVWriter csvWriter;

    @Override
    public void exportarEventoGastronomicoCsv(List<EventoGastronomico> eventoList){

        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("nuevos-eventoGastronomico.csv");

        try{
            this.csvWriter = new CSVWriter(new FileWriter(ruta));
            String[] encabezado = {"ID","NOMBRE","DESCRIPCION","FECHAYHORA","UBICACION", "CAPACIDADMAX", "CHEFACARGO"};
            this.csvWriter.writeNext(encabezado);

            for (EventoGastronomico eventoGastronomico : eventoList) {
                String[] datos = {
                    eventoGastronomico.getIdEvento().toString(),
                    eventoGastronomico.getNombre(),
                    eventoGastronomico.getDescripcion(),
                    eventoGastronomico.getFechaYHora().toString(),
                    eventoGastronomico.getUbicacion(),
                    eventoGastronomico.getCapacidadMax().toString(),
                    eventoGastronomico.getNombreChefAcargo().toString(),
                };
                this.csvWriter.writeNext(datos);
            }
            
            System.out.println("Archivo exportado");

        }catch (IOException e){
            System.out.println("Algo salio mal, motivo :" + e.getMessage().concat(" Ubicacion archivo : " + ruta));
        }
    }

    @Override
    public void cerrarWriter() {
        if (this.csvWriter != null){
            try{
                this.csvWriter.close();
            }catch (IOException e){
                System.out.println("Algo salio mal motivo :" + e.getMessage());
            }
        }
    }


}