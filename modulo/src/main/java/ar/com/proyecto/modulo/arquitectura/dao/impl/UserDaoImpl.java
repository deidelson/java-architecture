package ar.com.proyecto.modulo.arquitectura.dao.impl;

import ar.com.proyecto.modulo.arquitectura.dao.interf.UserDao;
import ar.com.proyecto.modulo.arquitectura.model.entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

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
       List<User> u = (List<User>) getEntityManager()
               .createQuery("select u from User u left join fetch u.roles where u.usuario = :nick", User.class)
               .setParameter( "nick", nick)
               .getResultList();

       return u != null && u.size()>0 ? u.get(0) : null;
    }

}
