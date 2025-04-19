package pe.edu.upc.homeserveconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.homeserveconnect.dto.UsuarioDTO;
import pe.edu.upc.homeserveconnect.entities.Usuario;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.insert(u);
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.searchById(id), UsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.update(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        uS.delete(id);
    }

    @GetMapping("/buscar/rol")
    public List<UsuarioDTO> buscarPorRol(@RequestParam String rol) {
        return uS.buscarPorRol(rol).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscar/empleo")
    public List<UsuarioDTO> buscarPorEmpleo(@RequestParam String empleo) {
        return uS.buscarPorEmpleo(empleo).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscar/nombre")
    public List<UsuarioDTO> buscarPorNombre(@RequestParam String nombre) {
        return uS.buscarPorNombre(nombre).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
