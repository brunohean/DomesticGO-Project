package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name= "resenias")
public class Resenias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  idResenias;
    @Column (name="fechaRegistros",nullable = false)
    private LocalDate fechaRegistros;
    @Column(name="detalles", nullable = false,length = 250)
    private String detalles;



    public Resenias() {
    }

    public Resenias(int idResenias, LocalDate fechaRegistros, String detalles) {
        this.idResenias = idResenias;
        this.fechaRegistros = fechaRegistros;
        this.detalles = detalles;
    }

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
