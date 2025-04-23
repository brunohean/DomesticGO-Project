package pe.edu.upc.homeserveconnect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false, length = 50)
    private String apellidoMaterno;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "foto", length = 255)
    private String foto;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;  // Relación con Rol

    @OneToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;  // Relación con Empleado

    public Usuario() {}

    public Usuario(int idUsuario, String username, String password, String nombres, String apellidoPaterno,
                   String apellidoMaterno, String email, String foto, Rol rol, Empleado empleado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.foto = foto;
        this.rol = rol;
        this.empleado = empleado;
    }

    // Getters and Setters
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
