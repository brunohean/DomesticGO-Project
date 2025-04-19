package pe.edu.upc.homeserveconnect.servicesinterfaces;

import pe.edu.upc.homeserveconnect.entities.Rol;

import java.util.List;

public interface IRolService {
    void insert(Rol rol);
    List<Rol> list();
    Rol searchById(int id);
    void delete(int id);
    void update(Rol rol);

    List<Rol> buscarPorNombre(String nombreRol); // ✅ nombre corregido
}

