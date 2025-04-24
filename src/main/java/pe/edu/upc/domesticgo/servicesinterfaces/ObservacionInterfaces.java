package pe.edu.upc.domesticgo.servicesinterfaces;

import pe.edu.upc.domesticgo.entities.Observacion;

import java.util.List;

public interface ObservacionInterfaces {
    public List<Observacion> LIST();
    public void Agregar(Observacion observacion);
    public void Eliminar (int id);
    public void Modificar(Observacion observacion);
}
