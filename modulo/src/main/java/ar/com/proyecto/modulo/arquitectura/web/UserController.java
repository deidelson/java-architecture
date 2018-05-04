package ar.com.proyecto.modulo.arquitectura.web;


import ar.com.proyecto.modulo.arquitectura.model.dto.ResponseDTO;
import ar.com.proyecto.modulo.arquitectura.model.dto.UserDTO;
import ar.com.proyecto.modulo.arquitectura.model.entity.User;
import ar.com.proyecto.modulo.arquitectura.security.JwtUtil;
import ar.com.proyecto.modulo.arquitectura.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping//(value = "/modulo/user")
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

    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> loggin(@RequestBody UserDTO user){
        HttpHeaders responseHeaders = new HttpHeaders();
        System.out.println("Entre");
        String token= responseHeaders.get(JwtUtil.TOKEN_HEADER).get(0);
        System.out.println("token "+token);
        return new ResponseEntity<>(token, responseHeaders, HttpStatus.OK);
    }
}
