package ar.com.proyecto.modulo.service.impl;

import ar.com.proyecto.modulo.arquitectura.model.ResponseDTO;
import ar.com.proyecto.modulo.model.dto.UserDTO;
import ar.com.proyecto.modulo.model.entity.User;
import ar.com.proyecto.modulo.model.mapper.UserMapper;
import ar.com.proyecto.modulo.persistencia.interfaces.UserDao;
import ar.com.proyecto.modulo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserDao dao;
    private UserMapper userMapper;

    public UserServiceImpl(@Autowired UserDao dao, @Autowired UserMapper userMapper) {
        this.dao = dao;
        this.userMapper = userMapper;
    }

    @Override
    public void save(UserDTO user) {
        dao.save(userMapper.toEntity(user));
    }

    @Override
    public List<UserDTO> findAll() {
        return dao.findAll().stream().map(u -> {
             return userMapper.toDTO(u);
        }).collect(Collectors.toList());
    }

    @Override
    public ResponseDTO<UserDTO> login(UserDTO user) {
        User u = dao.findUserByNickPass(user.getUsuario(), user.getContrasenia());

        ResponseDTO<UserDTO> ret = new ResponseDTO<>();

        ret.setObjeto(u != null ? userMapper.toDTO(u) : null);
        ret.setResponse(u != null ? "Exito" : "Credenciales incorrectas");

        return ret;
    }
}
