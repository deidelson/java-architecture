package ar.com.proyecto.modulo.web;


import ar.com.proyecto.modulo.arquitectura.model.ResponseDTO;
import ar.com.proyecto.modulo.model.dto.UserDTO;
import ar.com.proyecto.modulo.model.entity.User;
import ar.com.proyecto.modulo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/modulo/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "/saveUpdate")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody UserDTO user){
        service.save(user);
    }

    @GetMapping(value = "/listar",
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> listar(){
        return service.findAll();
    }
}
