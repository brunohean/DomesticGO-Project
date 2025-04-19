package pe.edu.upc.homeserveconnect.servicesinterfaces;

import pe.edu.upc.homeserveconnect.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    void insert(Usuario usuario);
    List<Usuario> list();
    Usuario searchById(int id);
    void update(Usuario usuario);
    void delete(int id);

    List<Usuario> buscarPorRol(String nombreRol);
    List<Usuario> buscarPorEmpleo(String empleo);
    List<Usuario> buscarPorNombre(String nombre);
}

