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
    private IUsuarioService usuarioService; // Inyección del servicio

    // Listar todos los usuarios
    @GetMapping("/listado")
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(usuario -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(usuario, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    // Buscar un usuario por ID
    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") int id) {
        Usuario usuario = usuarioService.searchId(id);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    // Insertar un nuevo usuario
    @PostMapping
    public void insertar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioService.insert(usuario); // Llamamos al servicio para insertar el usuario
    }

    // Modificar un usuario existente
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioService.update(usuario); // Llamamos al servicio para actualizar el usuario
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        usuarioService.delete(id); // Llamamos al servicio para eliminar el usuario
    }
}
