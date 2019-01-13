package ar.com.proyecto.architecture.arquitectura.web;


import ar.com.proyecto.architecture.arquitectura.model.dto.ResponseDTO;
import ar.com.proyecto.architecture.arquitectura.model.dto.UserDTO;
import ar.com.proyecto.architecture.arquitectura.model.entity.User;
import ar.com.proyecto.architecture.arquitectura.security.JwtUtil;
import ar.com.proyecto.architecture.arquitectura.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping//(value = "/architecture/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value = "/saveUpdate",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestBody UserDTO user){
       return service.save(user);
    }

    @GetMapping(value = "/listar",
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> listar(){
        return service.findAll();
    }

}
