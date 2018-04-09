package ar.com.proyecto.modulo.service.impl;

import ar.com.proyecto.modulo.model.entity.Persona;
import ar.com.proyecto.modulo.persistencia.interfaces.PersonaDao;
import ar.com.proyecto.modulo.service.interfaces.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    PersonaDao personaDao;

    public PersonaServiceImpl(@Autowired PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    @Override
    public List<Persona> findAll() {
        return personaDao.findAll();
    }
}
