package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.RolDTO;
import pe.edu.upc.domesticgo.entities.Rol;
import pe.edu.upc.domesticgo.entities.User;
import pe.edu.upc.domesticgo.servicesinterfaces.IRolService;
import pe.edu.upc.domesticgo.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@PreAuthorize("hasAnyAuthority('ADMIN')")
@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rolService;

    @Autowired
    private IUserService userService;


    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    @GetMapping("/listado")
    public List<RolDTO> listar() {
        return rolService.list().stream().map(rol -> {
            ModelMapper m = new ModelMapper();
            RolDTO dto = m.map(rol, RolDTO.class);
            dto.setUser(rol.getUser() != null ? rol.getUser().getId() : null);
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public void insertar(@RequestBody RolDTO rolDto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(rolDto, Rol.class);

        if (rolDto.getUser() != null) {
            User user = userService.searchId(rolDto.getUser());
            rol.setUser(user);
        }

        rolService.insert(rol);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody RolDTO rolDto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(rolDto, Rol.class);

        if (rolDto.getUser() != null) {
            User user = userService.searchId(rolDto.getUser());
            rol.setUser(user);
        }

        rolService.update(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rolService.delete(id);
    }

    @GetMapping("/{id}")
    public RolDTO buscarId(@PathVariable("id") int id) {
        Rol rol = rolService.searchId(id);
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rol, RolDTO.class);
        dto.setUser(rol.getUser() != null ? rol.getUser().getId() : null);
        return dto;
    }

    //Queries personalizados

    // Búsqueda por nombreRol
    @GetMapping("/buscar-rol")
    public List<RolDTO> buscar(@RequestParam String n) {
        return rolService.searchName(n).stream().map(rol -> {
            ModelMapper m = new ModelMapper();
            RolDTO dto = m.map(rol, RolDTO.class);
            dto.setUser(rol.getUser() != null ? rol.getUser().getId() : null);
            return dto;
        }).collect(Collectors.toList());
    }

}