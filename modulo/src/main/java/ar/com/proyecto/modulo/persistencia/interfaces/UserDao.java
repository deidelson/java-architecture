package ar.com.proyecto.modulo.persistencia.interfaces;

import ar.com.proyecto.modulo.arquitectura.dao.ArqDao;
import ar.com.proyecto.modulo.model.entity.User;

public interface UserDao extends ArqDao<User, String>{

    public boolean existsUserByUsuario(User user);
}
