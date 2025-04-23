package pe.edu.upc.homeserveconnect.servicesinterfaces;


import pe.edu.upc.homeserveconnect.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> list();  // Listar todos los usuarios
    void insert(Usuario usuario);  // Insertar un nuevo usuario
    Usuario searchId(int id);  // Buscar usuario por ID
    void update(Usuario usuario);  // Actualizar un usuario existente
    void delete(int id);  // Eliminar un usuario


}

