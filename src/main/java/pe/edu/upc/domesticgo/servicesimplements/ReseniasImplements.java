package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Observacion;
import pe.edu.upc.domesticgo.entities.Resenias;
import pe.edu.upc.domesticgo.repositories.ReseniasReposiroies;
import pe.edu.upc.domesticgo.servicesinterfaces.Reseniasinterfaces;

import java.util.List;

@Service
public class ReseniasImplements implements Reseniasinterfaces {
    @Autowired
    private ReseniasReposiroies rR;


    @Override
    public List<Resenias> LIST() {
        return rR.findAll();
    }

    @Override
    public void Agregar(Resenias resenias) {
        rR.save(resenias);
    }

    @Override
    public void Eliminar(int id) {
        rR.deleteById(id);

    }

    @Override
    public void Modificar(Resenias resenias) {
        rR.save(resenias);

    }
}
