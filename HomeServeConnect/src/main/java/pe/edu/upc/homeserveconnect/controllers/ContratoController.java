package pe.edu.upc.homeserveconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.homeserveconnect.dto.ContratoDTO;
import pe.edu.upc.homeserveconnect.entities.Contrato;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IContratoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private IContratoService cS;

    @GetMapping
    public List<ContratoDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ContratoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato c = m.map(dto, Contrato.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public ContratoDTO buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(cS.searchById(id), ContratoDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato c = m.map(dto, Contrato.class);
        cS.update(c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }

    @GetMapping("/buscar/contratante")
    public List<ContratoDTO> buscarPorContratante(@RequestParam int usuarioId) {
        return cS.buscarPorContratante(usuarioId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ContratoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscar/contratado")
    public List<ContratoDTO> buscarPorContratado(@RequestParam int usuarioId) {
        return cS.buscarPorContratado(usuarioId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ContratoDTO.class);
        }).collect(Collectors.toList());
    }
}
