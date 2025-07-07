package pe.edu.upc.domesticgo.dtos;

import pe.edu.upc.domesticgo.entities.Servicio;
import pe.edu.upc.domesticgo.entities.DetalleUsuario;

import java.time.LocalDate;

public class ReseniaDTO {
    private int idResenia;
    private LocalDate fechaResenia;
    private String detalleResenia;
    private DetalleUsuario detalleUsuario;
    private Servicio servicio;

    // Getters and Setters
    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public LocalDate getFechaResenia() {
        return fechaResenia;
    }

    public void setFechaResenia(LocalDate fechaResenia) {
        this.fechaResenia = fechaResenia;
    }

    public String getDetalleResenia() {
        return detalleResenia;
    }

    public void setDetalleResenia(String detalleResenia) {
        this.detalleResenia = detalleResenia;
    }

    public DetalleUsuario getUsuario() {
        return detalleUsuario;
    }

    public void setUsuario(DetalleUsuario detalleUsuario) {
        this.detalleUsuario = detalleUsuario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
