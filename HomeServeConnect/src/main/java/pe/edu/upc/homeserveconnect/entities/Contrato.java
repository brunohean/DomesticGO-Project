package pe.edu.upc.homeserveconnect.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrato;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaFinal", nullable = false)
    private LocalDate fechaFinal;

    @Column(name = "cadenaArchivo", length = 200)
    private String cadenaArchivo;

    @Column(name = "descripcionContrato", length = 300)
    private String descripcionContrato;

    @ManyToOne
    @JoinColumn(name = "idContratante", nullable = false)
    private Usuario contratante;

    @ManyToOne
    @JoinColumn(name = "idContratado", nullable = false)
    private Usuario contratado;

    @ManyToOne
    @JoinColumn(name = "idUbicacion", nullable = false)
    private Ubicacion ubicacion;

    public Contrato() {
    }

    // Getters y Setters
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
