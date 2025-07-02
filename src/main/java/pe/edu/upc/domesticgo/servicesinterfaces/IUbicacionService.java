package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Ubicacion;

import java.util.Collection;
import java.util.List;

public interface IUbicacionService {
    // Metodos de CRUD
    public List<Ubicacion> list();
    public void insert(Ubicacion user);
    public void update(Ubicacion user);
    public void delete(int id);
    public Ubicacion searchId(int id);
    // Metodos de Personalizados
    public List<Ubicacion> searchName(String n);
}
