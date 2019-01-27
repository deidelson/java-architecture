package ar.com.proyecto.architecture.dao.interf;

import ar.com.proyecto.architecture.model.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends ArqDao<User, Long>{

    public boolean existsUserByUsuario(User user);

    @Query("select u from User u where u.usuario = ?1")
    public User findUserByUser(String nick);
}
