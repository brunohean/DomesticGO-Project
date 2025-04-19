package pe.edu.upc.homeserveconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.homeserveconnect.dto.UbicacionDTO;
import pe.edu.upc.homeserveconnect.entities.Ubicacion;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IUbicacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    @Autowired
    private IUbicacionService uS;

    @GetMapping
    public List<UbicacionDTO> listar() {
        return uS.list().stream().map(u -> {
            ModelMapper m = new ModelMapper();
            return m.map(u, UbicacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UbicacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Ubicacion u = m.map(dto, Ubicacion.class);
        uS.insert(u);
    }

    @GetMapping("/{id}")
    public UbicacionDTO buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(uS.searchById(id), UbicacionDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody UbicacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Ubicacion u = m.map(dto, Ubicacion.class);
        uS.update(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        uS.delete(id);
    }

    @GetMapping("/buscar")
    public List<UbicacionDTO> buscarPorDireccion(@RequestParam String texto) {
        return uS.buscarPorDireccion(texto).stream().map(u -> {
            ModelMapper m = new ModelMapper();
            return m.map(u, UbicacionDTO.class);
        }).collect(Collectors.toList());
    }
}
