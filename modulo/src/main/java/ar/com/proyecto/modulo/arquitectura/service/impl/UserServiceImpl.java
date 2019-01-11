package ar.com.proyecto.modulo.arquitectura.service.impl;

import ar.com.proyecto.modulo.arquitectura.model.dto.ResponseDTO;
import ar.com.proyecto.modulo.arquitectura.model.dto.UserDTO;
import ar.com.proyecto.modulo.arquitectura.model.entity.Rol;
import ar.com.proyecto.modulo.arquitectura.model.entity.User;
import ar.com.proyecto.modulo.arquitectura.model.mapper.UserMapper;
import ar.com.proyecto.modulo.arquitectura.dao.interf.UserDao;
import ar.com.proyecto.modulo.arquitectura.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.ArrayList;
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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User usuario = dao.findUserByUser(s);

        if(usuario == null)
            throw new UsernameNotFoundException(String.format("El usuario %s no existe",s));

        List<GrantedAuthority> authorities = new ArrayList<>();
            usuario.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getNombreRol()));
            });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(usuario.getUsuario(), usuario.getContrasenia(), authorities);
        return  userDetails;
    }
}
