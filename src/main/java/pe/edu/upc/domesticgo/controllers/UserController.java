package pe.edu.upc.domesticgo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.UserDTO;
import pe.edu.upc.domesticgo.entities.Rol;
import pe.edu.upc.domesticgo.entities.User;
import pe.edu.upc.domesticgo.servicesinterfaces.IRolService;
import pe.edu.upc.domesticgo.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRolService rolService;

    // Metodos CRUD (listar, insertar, modificar, eliminar, buscarId)

    // Listar Usuarios (sin devolver el password)
    @GetMapping("/listado")
    public List<UserDTO> listar() {
        return userService.list().stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setEnabled(user.getEnabled());
            dto.setRolIds(user.getRoles().stream()
                    .map(Rol::getIdRol)
                    .collect(Collectors.toList())
            );
            return dto;
        }).collect(Collectors.toList());
    }

    // Registra un usuario (usa password recibido)
    @PostMapping("/registrar")
    public void insertar(@RequestBody UserDTO userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); // ← password viene del frontend
        user.setEnabled(userDto.getEnabled());

        if (userDto.getRolIds() != null) {
            List<Rol> roles = userDto.getRolIds().stream()
                    .map(id -> rolService.searchId(id))
                    .collect(Collectors.toList());
            user.setRoles(roles);
        }

        userService.insert(user);
    }

    // Modifica un usuario
    @PutMapping("/modificar")
    public void modificar(@RequestBody UserDTO userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); // ← se actualiza el password si se envía
        user.setEnabled(userDto.getEnabled());

        if (userDto.getRolIds() != null) {
            List<Rol> roles = userDto.getRolIds().stream()
                    .map(id -> rolService.searchId(id))
                    .collect(Collectors.toList());
            user.setRoles(roles);
        }

        userService.update(user);
    }

    // Elimina usuario
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    // Busca por id un usuario (sin devolver password)
    @GetMapping("/{id}")
    public UserDTO buscarId(@PathVariable("id") Long id) {
        User user = userService.searchId(id);
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEnabled(user.getEnabled());
        dto.setRolIds(user.getRoles().stream()
                .map(Rol::getIdRol)
                .collect(Collectors.toList()));
        return dto;
    }

    // Queries


    // Buscar por nombre de usuario (sin devolver password)
    @GetMapping("/buscar-rol")
    public List<UserDTO> buscar(@RequestParam String n) {
        return userService.searchNameUser(n).stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setEnabled(user.getEnabled());
            dto.setRolIds(user.getRoles().stream()
                    .map(Rol::getIdRol)
                    .collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }
}
