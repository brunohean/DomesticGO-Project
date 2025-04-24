package pe.edu.upc.domesticgo.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class ReseniaDtos {
    private int  idResenias;
    private LocalDate fechaRegistros;
    private String detalles;
    public int getIdResenias() {
        return idResenias;
    }

    public void setIdResenias(int idResenias) {
        this.idResenias = idResenias;
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
}
