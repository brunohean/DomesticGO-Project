package pe.edu.upc.domesticgo.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Credenciales")
public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "username", length = 30, unique = true)
        private String username;

        @Column(name = "password", length = 200)
        private String password;

        private Boolean enabled;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;  // Definiendo una relación ManyToOne con Role.

    @OneToMany(mappedBy = "users")
    private List<Usuario> usuarios; // Correlacionamos la propiedad 'usuario' que debe existir en 'Usuario'.


    // Constructor vacío
    public Users() {
    }

    // Constructor con parámetros

    public Users(Long id, String username, String password, Boolean enabled, Role role, List<Usuario> usuarios) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.usuarios = usuarios;
    }


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
