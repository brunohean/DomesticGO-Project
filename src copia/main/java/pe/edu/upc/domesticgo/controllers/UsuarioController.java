package pe.edu.upc.domesticgo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.UsuarioResponde;
import pe.edu.upc.domesticgo.entities.Usuario;
import pe.edu.upc.domesticgo.servicesinterfaces.IContratoService;
import pe.edu.upc.domesticgo.servicesinterfaces.IPagoService;
import pe.edu.upc.domesticgo.servicesinterfaces.IUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;


    @Autowired
    private IPagoService pagoService;

    @Autowired
    private IContratoService contratoService;

    // Obtener todos los usuarios
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TRABAJADOR')") // Control de acceso con roles
    public ResponseEntity<List<UsuarioResponde>> getUsuarios() {
        List<UsuarioResponde> usuarios = usuarioService.list();  // Llamada al servicio
        return ResponseEntity.ok(usuarios);  // Devolvemos la lista de usuarios
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TRABAJADOR')") // Control de acceso con roles
    public ResponseEntity<UsuarioResponde> getUsuario(@PathVariable int id) {
        UsuarioResponde usuario = usuarioService.searchId(id);  // Llamada al servicio
        if (usuario != null) {
            return ResponseEntity.ok(usuario);  // Si existe el usuario, lo devolvemos
        } else {
            return ResponseEntity.notFound().build();  // Si no se encuentra el usuario, devolvemos 404
        }
    }

    // Insertar un nuevo usuario
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")  // Solo los usuarios con rol ADMIN pueden crear
    public ResponseEntity<UsuarioResponde> insertUsuario(@RequestBody Usuario usuario) {
        UsuarioResponde usuarioResponde = usuarioService.insert(usuario);  // Llamada al servicio
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponde);  // Devolvemos el usuario insertado con status 201
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")  // Solo los usuarios con rol ADMIN pueden actualizar
    public ResponseEntity<UsuarioResponde> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        UsuarioResponde usuarioResponde = usuarioService.update(id, usuario);  // Llamada al servicio
        if (usuarioResponde != null) {
            return ResponseEntity.ok(usuarioResponde);  // Si se encuentra y actualiza correctamente, lo devolvemos
        } else {
            return ResponseEntity.notFound().build();  // Si no se encuentra el usuario, devolvemos 404
        }
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")  // Solo los usuarios con rol ADMIN pueden eliminar
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
        if (usuarioService.delete(id)) {
            return ResponseEntity.noContent().build();  // Si se elimina correctamente, devolvemos 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // Si no se encuentra el usuario, devolvemos 404
        }
    }


    // Endpoint para obtener el total pagado por un usuario en un mes específico
    @GetMapping("/{usuarioId}/total-pagado")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'OPERARIO')")
    public double getTotalPagado(@PathVariable Long usuarioId, @RequestParam int month, @RequestParam int year) {
        return pagoService.getTotalPagadoPorUsuario(usuarioId, month, year);
    }

    // Endpoint para obtener el número de contratos de un usuario en un mes específico
    @GetMapping("/{usuarioId}/numero-contratos")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'OPERARIO')")
    public long getNumeroContratos(@PathVariable Long usuarioId, @RequestParam int month, @RequestParam int year) {
        return contratoService.getNumeroContratosPorUsuario(usuarioId, month, year);
    }

    // Endpoint para obtener el total de servicios contratados por un usuario en un mes específico
    @GetMapping("/{usuarioId}/total-servicios")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'OPERARIO')")
    public long getTotalServiciosContratados(@PathVariable Long usuarioId, @RequestParam int month, @RequestParam int year) {
        return contratoService.getTotalServiciosContratados(usuarioId, month, year);
    }
}
