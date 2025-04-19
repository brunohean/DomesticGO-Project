package pe.edu.upc.homeserveconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.homeserveconnect.dto.PagoDTO;
import pe.edu.upc.homeserveconnect.entities.Pago;
import pe.edu.upc.homeserveconnect.servicesinterfaces.IPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private IPagoService pS;

    @GetMapping
    public List<PagoDTO> listar() {
        return pS.list().stream().map(p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody PagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Pago p = m.map(dto, Pago.class);
        pS.insert(p);
    }

    @GetMapping("/{id}")
    public PagoDTO buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(pS.searchById(id), PagoDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody PagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Pago p = m.map(dto, Pago.class);
        pS.update(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        pS.delete(id);
    }

    @GetMapping("/buscar/contrato")
    public List<PagoDTO> buscarPorContrato(@RequestParam int contratoId) {
        return pS.buscarPorContrato(contratoId).stream().map(p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscar/banco")
    public List<PagoDTO> buscarPorBanco(@RequestParam String banco) {
        return pS.buscarPorBanco(banco).stream().map(p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, PagoDTO.class);
        }).collect(Collectors.toList());
    }
}
