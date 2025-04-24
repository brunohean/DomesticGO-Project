package pe.edu.upc.domesticgo.dtos;

import java.time.LocalDate;

public class ObservacionDtos {
    private int  idObservacion;
    private LocalDate fechaRegistros;
    private String detalles;
    private Usuario usuario;
    private Servicio servicio;

    public int getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(int idObservacion) {
        this.idObservacion = idObservacion;
    }

    public LocalDate getFechaRegistros() {
        return fechaRegistros;
    }

    public void setFechaRegistros(LocalDate fechaRegistros) {
        this.fechaRegistros = fechaRegistros;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
