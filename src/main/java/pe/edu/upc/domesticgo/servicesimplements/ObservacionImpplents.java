package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Observacion;
import pe.edu.upc.domesticgo.repositories.ObservacionRepositories;
import pe.edu.upc.domesticgo.servicesinterfaces.ObservacionInterfaces;

import java.util.List;

@Service

public class ObservacionImpplents implements ObservacionInterfaces {
    @Autowired
    private ObservacionRepositories oR;

    @Override
    public List<Observacion> LIST() {
        return oR.findAll();
    }

    @Override
    public void Agregar(Observacion observacion) {
        oR.save(observacion);
    }

    @Override
    public void Eliminar(int id) {
        oR.deleteById(id);
    }

    @Override
    public void Modificar(Observacion observacion) {
        oR.save(observacion);
    }
}
