package pe.edu.upc.homeserveconnect.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.homeserveconnect.entities.Empleado;
import pe.edu.upc.homeserveconnect.repositories.IEmpleadoRepository;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IEmpleadoService;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> list() {
        return empleadoRepository.findAll();
    }

    @Override
    public void insert(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado searchId(int id) {
        return empleadoRepository.findById(id).orElse(new Empleado());
    }

    @Override
    public void update(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void delete(int id) {
        empleadoRepository.deleteById(id);
    }

}
