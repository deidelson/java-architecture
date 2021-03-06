package ar.com.proyecto.my.expenses.web;

import ar.com.proyecto.my.expenses.service.interfaces.PersonaService;
import ar.com.proyecto.my.expenses.model.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/modulo/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping(value = "/listar")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<PersonaDTO> getPersonas(){
        return personaService.findAll();
    }

    @PostMapping(value = "/saveUpdate",
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public PersonaDTO save(@RequestBody PersonaDTO p){
        return personaService.saveUpdate(p);
    }


    @GetMapping(value = "/listar"+"/{nombre}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<PersonaDTO> getPersonasPorNombre(@PathVariable String nombre){
        return personaService.findByNombre(nombre);
    }

    @DeleteMapping(value = "/borrar",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody PersonaDTO p){
        personaService.delete(p);
    }

}
