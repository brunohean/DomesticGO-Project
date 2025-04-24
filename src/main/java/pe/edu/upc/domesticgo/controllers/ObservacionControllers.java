package pe.edu.upc.domesticgo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.domesticgo.dtos.ObservacionDtos;
import pe.edu.upc.domesticgo.entities.Observacion;
import pe.edu.upc.domesticgo.servicesinterfaces.ObservacionInterfaces;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/observacion")
public class ObservacionControllers {
    @Autowired
    private ObservacionInterfaces oR;
    @GetMapping("/listar")
    public List<ObservacionDtos> listar() {
        return oR.LIST().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ObservacionDtos.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/agregar")
    public void  agregar(@RequestBody ObservacionDtos dto) {
        ModelMapper m = new ModelMapper();
        Observacion r = m.map(dto, Observacion.class);
        oR.Agregar(r);
    }
    @PutMapping("/modificar")
    public void modificar(@RequestBody ObservacionDtos dto) {
        ModelMapper m=new ModelMapper();
        Observacion c=m.map(dto,Observacion.class);
        oR.Modificar(c);
    }
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable("id") int id){
        oR.Eliminar(id);
    }


}
