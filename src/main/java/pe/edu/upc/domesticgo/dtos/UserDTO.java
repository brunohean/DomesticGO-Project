package pe.edu.upc.domesticgo.dtos;

import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private Boolean enabled;
    private String password;
    private List<Integer> rolIds; // ← solo los IDs, no los objetos Rol

    // Getters y Setters
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getRolIds() {
        return rolIds;
    }

    public void setRolIds(List<Integer> rolIds) {
        this.rolIds = rolIds;
    }
}