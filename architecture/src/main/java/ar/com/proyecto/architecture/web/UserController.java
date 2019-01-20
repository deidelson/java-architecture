package ar.com.proyecto.architecture.web;


import ar.com.proyecto.architecture.model.dto.LoginDTO;
import ar.com.proyecto.architecture.model.dto.UserDTO;
import ar.com.proyecto.architecture.model.entity.User;
import ar.com.proyecto.architecture.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
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

        List<UserDTO>ret  = service.findAll();
        return ret;
    }

    @PostMapping(value = "/login",
     produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public LoginDTO login(@RequestBody LoginDTO loginDTO) {
        LoginDTO ret = new LoginDTO()
                .setToken("token hardcodeado")
                .setUsuario("User logueado");
        return ret;
    }


}
