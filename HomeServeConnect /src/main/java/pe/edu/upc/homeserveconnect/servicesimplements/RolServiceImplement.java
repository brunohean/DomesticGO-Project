package pe.edu.upc.homeserveconnect.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.homeserveconnect.entities.Rol;
import pe.edu.upc.homeserveconnect.repositories.IRolRepository;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rR;

    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public Rol searchById(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }

    @Override
    public List<Rol> buscarPorNombre(String nombreRol) {
        return rR.buscarPorNombre(nombreRol);
    }
}
