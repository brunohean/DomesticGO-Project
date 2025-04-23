package pe.edu.upc.homeserveconnect.servicesinterfaces;

import pe.edu.upc.homeserveconnect.entities.Empleado;

import java.util.List;

public interface IEmpleadoService {
    List<Empleado> list();  // Listar todos los empleados

    void insert(Empleado empleado);  // Insertar un nuevo empleado

    Empleado searchId(int id);  // Buscar empleado por ID

    void update(Empleado empleado);  // Actualizar un empleado existente

    void delete(int id);  // Eliminar un empleado

}
