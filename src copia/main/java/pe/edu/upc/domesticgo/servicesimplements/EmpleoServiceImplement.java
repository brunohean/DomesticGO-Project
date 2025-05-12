package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Empleo;
import pe.edu.upc.domesticgo.repositories.IEmpleoRepository;
import pe.edu.upc.domesticgo.servicesinterfaces.IEmpleoService;

import java.util.List;

@Service
public class EmpleoServiceImplement implements IEmpleoService {

    @Autowired
    private IEmpleoRepository empleoRepository;

    // Implementación de Métodos CRUD
    @Override
    public List<Empleo> list() {
        return empleoRepository.findAll();  // Obtiene todos los empleos
    }

    @Override
    public void insert(Empleo empleo) {
        empleoRepository.save(empleo);  // Inserta un nuevo empleo
    }

    @Override
    public void update(Empleo empleo) {
        empleoRepository.save(empleo);  // Actualiza un empleo existente
    }

    @Override
    public void delete(int id) {
        empleoRepository.deleteById(id);  // Elimina el empleo por ID
    }

    @Override
    public Empleo searchId(int id) {
        return empleoRepository.findById(id).orElse(null);  // Busca un empleo por su ID
    }
}
