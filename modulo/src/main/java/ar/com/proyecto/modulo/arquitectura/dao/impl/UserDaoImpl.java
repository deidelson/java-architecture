package ar.com.proyecto.modulo.arquitectura.dao.impl;

import ar.com.proyecto.modulo.arquitectura.dao.interf.UserDao;
import ar.com.proyecto.modulo.arquitectura.model.entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@Primary
public class UserDaoImpl extends ArqDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl(EntityManager em) {
        super(User.class, em);
    }

    @Override
    public boolean existsUserByUsuario(User user) {
        return false;
    }

    @Override
    public User findUserByUser(String nick) {
        return null;
    }

}
