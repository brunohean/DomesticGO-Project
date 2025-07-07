package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.domesticgo.dtos.DetalleUsuarioDTO;

import pe.edu.upc.domesticgo.entities.DetalleUsuario;
import pe.edu.upc.domesticgo.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalle-usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuaService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<DetalleUsuarioDTO> listar() {
        return usuaService.list().stream().map(n ->{
            ModelMapper m=new ModelMapper();
            return m.map(n, DetalleUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody DetalleUsuarioDTO usuaDto){
        ModelMapper m=new ModelMapper();
        DetalleUsuario usua=m.map(usuaDto, DetalleUsuario.class);
        usuaService.insert(usua);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody DetalleUsuarioDTO usuaDto){
        ModelMapper m=new ModelMapper();
        DetalleUsuario usua=m.map(usuaDto, DetalleUsuario.class);
        usuaService.update(usua);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        usuaService.delete(id);
    }

    @GetMapping("/{id}")
    public DetalleUsuarioDTO buscarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        DetalleUsuarioDTO dto=m.map(usuaService.searchId(id), DetalleUsuarioDTO.class);
        return dto;
    }
}
