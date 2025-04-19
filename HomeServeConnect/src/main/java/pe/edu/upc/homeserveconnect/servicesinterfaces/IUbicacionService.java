package pe.edu.upc.homeserveconnect.servicesinterfaces;

import pe.edu.upc.homeserveconnect.entities.Ubicacion;

import java.util.List;

public interface IUbicacionService {
    void insert(Ubicacion ubicacion);
    List<Ubicacion> list();
    Ubicacion searchById(int id);
    void delete(int id);
    void update(Ubicacion ubicacion);

    List<Ubicacion> buscarPorDireccion(String texto); // ✅ Nombre alineado con repository
}
