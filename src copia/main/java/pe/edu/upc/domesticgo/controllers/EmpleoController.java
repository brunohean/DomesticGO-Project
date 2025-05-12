package pe.edu.upc.domesticgo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.entities.Empleo;
import pe.edu.upc.domesticgo.servicesinterfaces.IEmpleoService;

import java.util.List;

@RestController
@RequestMapping("/empleos")
public class EmpleoController {

    @Autowired
    private IEmpleoService empleoService;

    // Obtener todos los empleos (solo ADMIN y OPERARIO)
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TRABAJADOR')")
    public ResponseEntity<List<Empleo>> getEmpleos() {
        List<Empleo> empleos = empleoService.list();
        return ResponseEntity.ok(empleos);
    }

    // Obtener un empleo por ID (solo ADMIN y OPERARIO)
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TRABAJADOR')")
    public ResponseEntity<Empleo> getEmpleo(@PathVariable int id) {
        Empleo empleo = empleoService.searchId(id);
        if (empleo != null) {
            return ResponseEntity.ok(empleo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar un nuevo empleo (solo ADMIN)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> insertEmpleo(@RequestBody Empleo empleo) {
        empleoService.insert(empleo);
        return ResponseEntity.status(201).build();
    }

    // Actualizar un empleo (solo ADMIN)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> updateEmpleo(@PathVariable int id, @RequestBody Empleo empleo) {
        empleo.setIdEmpleo(id);
        empleoService.update(empleo);
        return ResponseEntity.noContent().build();
    }

    // Eliminar un empleo (solo ADMIN)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteEmpleo(@PathVariable int id) {
        empleoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
