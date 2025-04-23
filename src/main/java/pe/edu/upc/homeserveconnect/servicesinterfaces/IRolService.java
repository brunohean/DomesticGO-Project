package pe.edu.upc.homeserveconnect.servicesinterfaces;

import pe.edu.upc.homeserveconnect.entities.Rol;

import java.util.List;

public interface IRolService {
    List<Rol> list();  // Listar todos los roles
    void insert(Rol rol);  // Insertar un nuevo rol
    Rol searchId(int id);  // Buscar rol por ID
    void update(Rol rol);  // Actualizar un rol existente
    void delete(int id);  // Eliminar un rol
}

