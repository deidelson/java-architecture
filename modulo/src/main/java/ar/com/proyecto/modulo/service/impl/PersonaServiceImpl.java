package ar.com.proyecto.modulo.service.impl;

import ar.com.proyecto.modulo.model.entity.Persona;
import ar.com.proyecto.modulo.persistencia.interfaces.PersonaDao;
import ar.com.proyecto.modulo.service.interfaces.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService{

    PersonaDao personaDao;

    public PersonaServiceImpl(@Autowired PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    @Override
    public List<Persona> findAll() {
        return personaDao.findAll();
    }

    @Override
    public void saveUpdate(Persona p) {
        personaDao.save(p);
    }

    @Override
    public void delete(Persona p) {
        personaDao.delete(p.getId());
    }

    @Override
    public Persona findById(Persona p) {
        return personaDao.findOne(p.getId());
    }

    @Override
    public List<Persona>findByNombre(String nombre){
        return personaDao.findByNombre(nombre);
    }
}
