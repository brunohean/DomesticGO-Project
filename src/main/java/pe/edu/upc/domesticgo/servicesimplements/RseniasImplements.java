package pe.edu.upc.domesticgo.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.domesticgo.entities.Resenias;
import pe.edu.upc.domesticgo.repositories.ReseniasRepositories;
import pe.edu.upc.domesticgo.servicesinterfaces.ReseniasInterfaces;

import java.util.List;
@Service

public class RseniasImplements implements ReseniasInterfaces {
    @Autowired
    private ReseniasRepositories rR;
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
