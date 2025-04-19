package pe.edu.upc.homeserveconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.homeserveconnect.dto.EmpleoDTO;
import pe.edu.upc.homeserveconnect.entities.Empleo;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IEmpleoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleos")
public class EmpleoController {

    @Autowired
    private IEmpleoService eS;

    @GetMapping
    public List<EmpleoDTO> listar() {
        return eS.list().stream().map(e -> {
            ModelMapper m = new ModelMapper();
            return m.map(e, EmpleoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EmpleoDTO dto) {
        ModelMapper m = new ModelMapper();
        Empleo e = m.map(dto, Empleo.class);
        eS.insert(e);
    }

    @GetMapping("/{id}")
    public EmpleoDTO buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(eS.searchById(id), EmpleoDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody EmpleoDTO dto) {
        ModelMapper m = new ModelMapper();
        Empleo e = m.map(dto, Empleo.class);
        eS.update(e);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        eS.delete(id);
    }

    @GetMapping("/buscar")
    public List<EmpleoDTO> buscarPorNombre(@RequestParam String nombre) {
        return eS.buscarPorNombre(nombre).stream().map(e -> {
            ModelMapper m = new ModelMapper();
            return m.map(e, EmpleoDTO.class);
        }).collect(Collectors.toList());
    }
}
