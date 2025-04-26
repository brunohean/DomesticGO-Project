package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="resenias")
public class Resenias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idResenia;
    @Column (name="fecharesenia",nullable=false)
    private LocalDate fecharesenia;
    @Column (name ="Detalles",nullable = false,length = 1000)
    private String Detalles;

    public Resenias() {
    }

    public Resenias(int idResenia, LocalDate fecharesenia, String detalles) {
        this.idResenia = idResenia;
        this.fecharesenia = fecharesenia;
        Detalles = detalles;
    }

    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public LocalDate getFecharesenia() {
        return fecharesenia;
    }

    public void setFecharesenia(LocalDate fecharesenia) {
        this.fecharesenia = fecharesenia;
    }

    public String getDetalles() {
        return Detalles;
    }

    public void setDetalles(String detalles) {
        Detalles = detalles;
    }
}
