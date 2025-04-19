package pe.edu.upc.homeserveconnect.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.homeserveconnect.entities.Empleo;
import pe.edu.upc.homeserveconnect.repositories.IEmpleoRepository;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IEmpleoService;

import java.util.List;

@Service
public class EmpleoServiceImplement implements IEmpleoService {

    @Autowired
    private IEmpleoRepository eR;

    @Override
    public void insert(Empleo empleo) {
        eR.save(empleo);
    }

    @Override
    public List<Empleo> list() {
        return eR.findAll();
    }

    @Override
    public Empleo searchById(int id) {
        return eR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public void update(Empleo empleo) {
        eR.save(empleo);
    }

    @Override
    public List<Empleo> buscarPorNombre(String nombreEmpleo) {
        return eR.buscarPorNombre(nombreEmpleo);
    }
}
