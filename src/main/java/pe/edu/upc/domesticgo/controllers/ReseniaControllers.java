package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ReseniaDtos;
import pe.edu.upc.domesticgo.entities.Resenias;
import pe.edu.upc.domesticgo.servicesinterfaces.ReseniasInterfaces;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenia")
public class ReseniaControllers {
    @Autowired
    private ReseniasInterfaces rI;
    @GetMapping("/listar")
    public List<ReseniaDtos> listar() {
        return rI.LIST().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ReseniaDtos.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/agregar")
    public void  agregar(@RequestBody ReseniaDtos dto) {
        ModelMapper m = new ModelMapper();
        Resenias r = m.map(dto, Resenias.class);
        rI.Agregar(r);
    }
    @PutMapping("/modificar")
    public void modificar(@RequestBody ReseniaDtos dto) {
        ModelMapper m=new ModelMapper();
        Resenias c=m.map(dto,Resenias.class);
        rI.Modificar(c);
    }
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable("id") int id){
        rI.Eliminar(id);
    }


}
