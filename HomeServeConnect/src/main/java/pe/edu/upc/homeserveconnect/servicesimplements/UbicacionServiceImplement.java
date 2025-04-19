package pe.edu.upc.homeserveconnect.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.homeserveconnect.entities.Ubicacion;
import pe.edu.upc.homeserveconnect.repositories.IUbicacionRepository;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IUbicacionService;

import java.util.List;

@Service
public class UbicacionServiceImplement implements IUbicacionService {

    @Autowired
    private IUbicacionRepository uR;

    @Override
    public void insert(Ubicacion ubicacion) {
        uR.save(ubicacion);
    }

    @Override
    public List<Ubicacion> list() {
        return uR.findAll();
    }

    @Override
    public Ubicacion searchById(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public void update(Ubicacion ubicacion) {
        uR.save(ubicacion);
    }

    @Override
    public List<Ubicacion> buscarPorDireccion(String texto) {
        return uR.buscarPorDireccion(texto); // 💡 exactamente igual al nombre del repo
    }
}
