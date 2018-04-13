package ar.com.proyecto.modulo.persistencia.interfaces;

import ar.com.proyecto.modulo.arquitectura.dao.ArqDao;
import ar.com.proyecto.modulo.model.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends ArqDao<User, String>{

    public boolean existsUserByUsuario(User user);

    @Query("select u from User u where u.usuario = ?1 and u.contrasenia = ?2")
    public User findUserByNickPass(String nick, String pass);
}
