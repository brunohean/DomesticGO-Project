package pe.edu.upc.homeserveconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.homeserveconnect.dto.RolDTO;
import pe.edu.upc.homeserveconnect.entities.Rol;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rS;

    @GetMapping
    public List<RolDTO> listar() {
        return rS.list().stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rS.insert(r);
    }

    @GetMapping("/{id}")
    public RolDTO buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(rS.searchById(id), RolDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rS.update(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }

    @GetMapping("/buscar")
    public List<RolDTO> buscarPorNombre(@RequestParam String nombreRol) {
        return rS.buscarPorNombre(nombreRol).stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, RolDTO.class);
        }).collect(Collectors.toList());
    }
}
