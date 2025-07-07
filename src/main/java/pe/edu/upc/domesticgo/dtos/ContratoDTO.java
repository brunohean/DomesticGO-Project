package pe.edu.upc.domesticgo.dtos;

import pe.edu.upc.domesticgo.entities.Ubicacion;
import pe.edu.upc.domesticgo.entities.DetalleUsuario;

import java.time.LocalDate;

public class ContratoDTO {
    private int idContrato;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String archivo;
    private String descripcionContrato;
    private DetalleUsuario contratante;
    private DetalleUsuario contratado;
    private Ubicacion ubicacion;

    // Getters and Setters
    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getDescripcionContrato() {
        return descripcionContrato;
    }

    public void setDescripcionContrato(String descripcionContrato) {
        this.descripcionContrato = descripcionContrato;
    }

    public DetalleUsuario getContratante() {
        return contratante;
    }

    public void setContratante(DetalleUsuario contratante) {
        this.contratante = contratante;
    }

    public DetalleUsuario getContratado() {
        return contratado;
    }

    public void setContratado(DetalleUsuario contratado) {
        this.contratado = contratado;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
