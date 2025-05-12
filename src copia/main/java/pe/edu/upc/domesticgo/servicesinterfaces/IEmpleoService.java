package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Empleo;
import java.util.List;

public interface IEmpleoService {

    // Métodos CRUD
    public List<Empleo> list();            // Obtener todos los empleos
    public void insert(Empleo empleo);     // Insertar un empleo
    public void update(Empleo empleo);     // Actualizar un empleo existente
    public void delete(int id);            // Eliminar un empleo por ID
    public Empleo searchId(int id);        // Buscar un empleo por su ID
}
