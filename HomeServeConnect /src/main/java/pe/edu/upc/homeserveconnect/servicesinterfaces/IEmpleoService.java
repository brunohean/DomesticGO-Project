package pe.edu.upc.homeserveconnect.servicesinterfaces;

import pe.edu.upc.homeserveconnect.entities.Empleo;

import java.util.List;

public interface IEmpleoService {
    void insert(Empleo empleo);
    List<Empleo> list();
    Empleo searchById(int id);
    void delete(int id);
    void update(Empleo empleo);

    List<Empleo> buscarPorNombre(String nombreEmpleo); // ✅ corregido
}
