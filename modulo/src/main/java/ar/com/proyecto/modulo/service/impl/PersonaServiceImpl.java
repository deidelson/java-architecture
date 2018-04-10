package ar.com.proyecto.modulo.service.impl;

import ar.com.proyecto.modulo.model.dto.PersonaDTO;
import ar.com.proyecto.modulo.model.entity.Persona;
import ar.com.proyecto.modulo.model.mapper.PersonaMapper;
import ar.com.proyecto.modulo.persistencia.interfaces.PersonaDao;
import ar.com.proyecto.modulo.service.interfaces.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService{

    PersonaDao personaDao;
    PersonaMapper personaMapper;

    public PersonaServiceImpl(@Autowired PersonaDao personaDao, @Autowired PersonaMapper personaMapper) {
        this.personaDao = personaDao;
        this.personaMapper= personaMapper;
    }

    @Override
    public List<PersonaDTO> findAll() {
        List<PersonaDTO> ret = new ArrayList<>();
        personaDao.findAll().forEach(p -> ret.add(personaMapper.toDTO(p)));
        return ret;
    }

    @Override
    public void saveUpdate(PersonaDTO p) {
        personaDao.save(personaMapper.toEntity(p));
    }

    @Override
    public void delete(PersonaDTO p) {
        personaDao.delete(p.getId());
    }

    @Override
    public PersonaDTO findById(PersonaDTO p) {
        Persona persona = personaMapper.toEntity(p);
        return personaMapper.toDTO(personaDao.findOne(persona.getId()));
    }

    @Override
    public List<PersonaDTO>findByNombre(String nombre){
        List<PersonaDTO> ret = new ArrayList<>();
        personaDao.findByNombre(nombre).forEach(p -> ret.add(personaMapper.toDTO(p)));
        return ret;
    }
}
