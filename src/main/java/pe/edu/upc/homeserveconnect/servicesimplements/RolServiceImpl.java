package pe.edu.upc.homeserveconnect.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.homeserveconnect.entities.Rol;
import pe.edu.upc.homeserveconnect.repositories.IRolRepository;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {
    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<Rol> list() {
        return rolRepository.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public Rol searchId(int id) {
        return rolRepository.findById(id).orElse(new Rol());
    }

    @Override
    public void update(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(int id) {
        rolRepository.deleteById(id);
    }
}
