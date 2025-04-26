package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ObservacionDtos;
import pe.edu.upc.domesticgo.dtos.ReseniasDtos;
import pe.edu.upc.domesticgo.entities.Observacion;
import pe.edu.upc.domesticgo.entities.Resenias;
import pe.edu.upc.domesticgo.servicesinterfaces.Reseniasinterfaces;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenia")

public class ReseniasControllers {
    @Autowired
    private Reseniasinterfaces rR;
    @GetMapping("/listar")
    public List<ReseniasDtos> listar() {
        return rR.LIST().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ReseniasDtos.class);
        }).collect(Collectors.toList());

    }
    @PostMapping("/agregar")
    public void agregar(@RequestBody ReseniasDtos dto) {
        ModelMapper m = new ModelMapper();
        Resenias r = m.map(dto, Resenias.class);
        rR.Agregar(r);

    }
    @PutMapping("/modificar")
    public void modificar(@RequestBody ReseniasDtos dto) {
        ModelMapper m=new ModelMapper();
        Resenias c=m.map(dto,Resenias.class);
        rR.Modificar(c);
    }
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable("id") int id){
        rR.Eliminar(id);
    }



}
