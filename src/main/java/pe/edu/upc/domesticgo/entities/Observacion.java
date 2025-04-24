package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name =  "Observacion")
public class Observacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idobservacion;
    @Column(name="fechaObservacion", nullable=false)
    private LocalDate fechaObservacion;
    @Column(name ="DetallesObservacion",nullable = false,length = 1000)
    private String DetallesObservacion;
    @ManyToOne
    @JoinColumn(name =idUsuario)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name =idServicio)
    private Servicio servicio;

    public Observacion() {
    }

    public Observacion(int idobservacion, LocalDate fechaObservacion, String detallesObservacion, Usuario usuario, Servicio servicio) {
        this.idobservacion = idobservacion;
        this.fechaObservacion = fechaObservacion;
        DetallesObservacion = detallesObservacion;
        this.usuario = usuario;
        this.servicio = servicio;
    }

    public int getIdobservacion() {
        return idobservacion;
    }

    public void setIdobservacion(int idobservacion) {
        this.idobservacion = idobservacion;
    }

    public LocalDate getFechaObservacion() {
        return fechaObservacion;
    }

    public void setFechaObservacion(LocalDate fechaObservacion) {
        this.fechaObservacion = fechaObservacion;
    }

    public String getDetallesObservacion() {
        return DetallesObservacion;
    }

    public void setDetallesObservacion(String detallesObservacion) {
        DetallesObservacion = detallesObservacion;
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
