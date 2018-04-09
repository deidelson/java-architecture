package ar.com.proyecto.modulo.web;

import ar.com.proyecto.modulo.model.entity.Persona;
import ar.com.proyecto.modulo.service.interfaces.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/modulo/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping(value = "/listar")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> getPersonas(){
        return personaService.findAll();
    }

    @PostMapping(value = "/guardar",
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody Persona p){
        personaService.save(p);
    }

    @GetMapping(value = "/listar"+"/{nombre}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> getPersonasPorNombre(@PathVariable String nombre){
        return personaService.findByNombre(nombre);
    }
}
