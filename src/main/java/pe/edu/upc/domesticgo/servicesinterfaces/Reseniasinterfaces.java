package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Observacion;
import pe.edu.upc.domesticgo.entities.Resenias;

import java.util.List;

public interface Reseniasinterfaces {
    public List<Resenias> LIST();
    public void Agregar(Resenias resenias);
    public void Eliminar (int id);
    public void Modificar(Resenias resenias);
}
