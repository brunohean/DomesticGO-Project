package pe.edu.upc.homeserveconnect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "username", length = 30, nullable = false)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;

    @Column(name = "apellidoPaterno", length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(name = "email", length = 60, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "idEmpleo")
    private Empleo empleo;

    public Usuario() {
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empleo getEmpleo() {
        return empleo;
    }

    public void setEmpleo(Empleo empleo) {
        this.empleo = empleo;
    }
}

