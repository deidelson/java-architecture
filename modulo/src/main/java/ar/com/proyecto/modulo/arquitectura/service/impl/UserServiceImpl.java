package ar.com.proyecto.modulo.arquitectura.service.impl;

import ar.com.proyecto.modulo.arquitectura.model.dto.ResponseDTO;
import ar.com.proyecto.modulo.arquitectura.model.dto.UserDTO;
import ar.com.proyecto.modulo.arquitectura.model.entity.Rol;
import ar.com.proyecto.modulo.arquitectura.model.entity.User;
import ar.com.proyecto.modulo.arquitectura.model.mapper.UserMapper;
import ar.com.proyecto.modulo.arquitectura.dao.interf.UserDao;
import ar.com.proyecto.modulo.arquitectura.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao dao;
    private UserMapper userMapper;

    public UserServiceImpl(@Autowired UserDao dao, @Autowired UserMapper userMapper) {
        this.dao = dao;
        this.userMapper = userMapper;
    }

    @Override
    public User save(UserDTO user) {
        return dao.save(userMapper.toEntity(user));
    }

    @Override
    public List<UserDTO> findAll() {
        return dao.findAll().stream().map(u -> {
             return userMapper.toDTO(u);
        }).collect(Collectors.toList());
    }

    @Override
    public ResponseDTO<UserDTO> login(UserDTO user) {
        User u = dao.findUserByUser(user.getUsuario());

        ResponseDTO<UserDTO> ret = new ResponseDTO<>();

        ret.setObjeto(u != null && u.getContrasenia().equals(user.getContrasenia()) ? userMapper.toDTO(u) : null);
        ret.setResponse(u != null && u.getContrasenia().equals(user.getContrasenia()) ? "Exito" : "Credenciales incorrectas");

        return ret;
    }

/*    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = dao.findUserByUser(s);

        *//*List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(u.getUsuario(), u.getContrasenia());*//*
        return  null;
    }*/
}
