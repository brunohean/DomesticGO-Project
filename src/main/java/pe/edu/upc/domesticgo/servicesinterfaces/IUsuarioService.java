package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.DetalleUsuario;

import java.util.List;

public interface IUsuarioService {
    // Metodos de CRUD
    public List<DetalleUsuario> list();
    public void insert(DetalleUsuario user);
    public void update(DetalleUsuario user);
    public void delete(int id);
    public DetalleUsuario searchId(int id);

}
