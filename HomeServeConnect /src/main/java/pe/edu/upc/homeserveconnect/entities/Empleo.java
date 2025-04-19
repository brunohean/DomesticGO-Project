package pe.edu.upc.homeserveconnect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleo")
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleo;

    @Column(name = "nombreEmpleo", length = 50, nullable = false)
    private String nombreEmpleo;

    public Empleo() {
    }

    public int getIdEmpleo() {
        return idEmpleo;
    }

    public void setIdEmpleo(int idEmpleo) {
        this.idEmpleo = idEmpleo;
    }

    public String getNombreEmpleo() {
        return nombreEmpleo;
    }

    public void setNombreEmpleo(String nombreEmpleo) {
        this.nombreEmpleo = nombreEmpleo;
    }
}
