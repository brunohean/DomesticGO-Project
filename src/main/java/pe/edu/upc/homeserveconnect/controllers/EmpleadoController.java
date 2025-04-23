package pe.edu.upc.homeserveconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.homeserveconnect.dto.EmpleadoDTO;
import pe.edu.upc.homeserveconnect.entities.Empleado;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IEmpleadoService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/listado")
    public List<EmpleadoDTO> listar() {
        return empleadoService.list().stream().map(p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, EmpleadoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EmpleadoDTO dto) {
        ModelMapper m = new ModelMapper();
        Empleado empleado = m.map(dto, Empleado.class);
        empleadoService.insert(empleado);
    }

    @GetMapping("/{id}")
    public EmpleadoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(empleadoService.searchId(id), EmpleadoDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody EmpleadoDTO dto) {
        ModelMapper m = new ModelMapper();
        Empleado empleado = m.map(dto, Empleado.class);
        empleadoService.update(empleado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        empleadoService.delete(id);
    }

}
