package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleo")
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleo;

    @Column(name = "nombreEmpleo", nullable = false, length = 100)
    private String nombreEmpleo;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    // Constructor vacío
    public Empleo() {
    }

    // Constructor con parámetros
    public Empleo(int idEmpleo, String nombreEmpleo, Usuario usuario) {
        this.idEmpleo = idEmpleo;
        this.nombreEmpleo = nombreEmpleo;
        this.usuario = usuario;
    }

    // Getters and Setters
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
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
