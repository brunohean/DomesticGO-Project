package pe.edu.upc.homeserveconnect.dto;

import pe.edu.upc.homeserveconnect.entities.Usuario;
import pe.edu.upc.homeserveconnect.entities.Ubicacion;

import java.time.LocalDate;

public class ContratoDTO {

    private int idContrato;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private String cadenaArchivo;
    private String descripcionContrato;
    private Usuario contratante;
    private Usuario contratado;
    private Ubicacion ubicacion;

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

    public String getCadenaArchivo() {
        return cadenaArchivo;
    }

    public void setCadenaArchivo(String cadenaArchivo) {
        this.cadenaArchivo = cadenaArchivo;
    }

    public String getDescripcionContrato() {
        return descripcionContrato;
    }

    public void setDescripcionContrato(String descripcionContrato) {
        this.descripcionContrato = descripcionContrato;
    }

    public Usuario getContratante() {
        return contratante;
    }

    public void setContratante(Usuario contratante) {
        this.contratante = contratante;
    }

    public Usuario getContratado() {
        return contratado;
    }

    public void setContratado(Usuario contratado) {
        this.contratado = contratado;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}
