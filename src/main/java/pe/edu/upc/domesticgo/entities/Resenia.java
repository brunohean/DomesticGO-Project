package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Resenia")
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResenia;

    @Column(name = "fechaResenia", nullable = false)
    private LocalDate fechaResenia;

    @Column(name = "detalleResenia", nullable = false, length = 200)
    private String detalleResenia;

    // Foreign Keys @ManytoOne Usuario y Servicio

    @ManyToOne
    @JoinColumn(name = "idUsuario",nullable = false)
    private DetalleUsuario detalleUsuario;

    @ManyToOne
    @JoinColumn(name = "idServicio",nullable = false)
    private Servicio servicio;

    // Constructores, Getters and Setters (falta constructores completo y llave foranea)

    public Resenia() {
    }

    public Resenia(int idResenia, LocalDate fechaResenia, String detalleResenia, DetalleUsuario detalleUsuario, Servicio servicio) {
        this.idResenia = idResenia;
        this.fechaResenia = fechaResenia;
        this.detalleResenia = detalleResenia;
        this.detalleUsuario = detalleUsuario;
        this.servicio = servicio;
    }

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
