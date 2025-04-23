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
    private IRolService rolService;

    @GetMapping("/listado")
    public List<RolDTO> listar() {
        return rolService.list().stream().map(p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rolService.insert(rol);
    }

    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(rolService.searchId(id), RolDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rolService.update(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rolService.delete(id);
    }
}
