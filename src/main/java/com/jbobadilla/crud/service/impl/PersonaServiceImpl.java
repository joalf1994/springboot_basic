package com.jbobadilla.crud.service.impl;

import com.jbobadilla.crud.dto.PersonaDto;
import com.jbobadilla.crud.mapper.IPersonaMapper;
import com.jbobadilla.crud.model.Persona;
import com.jbobadilla.crud.repository.IPersonaRepository;
import com.jbobadilla.crud.service.IPersonaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import javax.swing.text.Utilities;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService {
    private final IPersonaRepository personaRepository;
    private final IPersonaMapper personaMapper;
    private final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    public PersonaServiceImpl(IPersonaRepository personaRepository, IPersonaMapper personaMapper, MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
        this.mappingJackson2HttpMessageConverter = mappingJackson2HttpMessageConverter;
    }

    @Override
    public PersonaDto createPersona(PersonaDto personaDto) {
        Persona p = personaRepository.save(personaMapper.mapToPersona(personaDto));
        return personaMapper.mapToPersonaDto(p);
    }

    @Override
    public List<PersonaDto> getAllPersonas() {
        List<Persona> personaList = personaRepository.findAll();
        List<PersonaDto> personaDtoList = personaList.stream()
                .map(personaMapper::mapToPersonaDto).toList();
        return personaDtoList;
    }

    @Override
    public PersonaDto getPersonaById(Long id) {
        Optional<Persona> p = personaRepository.findById(id);
        return personaMapper.mapToPersonaDto(p.get());
    }


    @Override
    public PersonaDto updatePersona(PersonaDto personaDto) {
        Persona p = personaMapper.mapToPersona(personaDto);
        boolean encontrado = personaRepository.existsById(p.getId());
        if (encontrado) {
            p = personaRepository.save(p);
            return personaMapper.mapToPersonaDto(p);
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void deletePersona(Long id) {
        boolean encontrado = personaRepository.existsById(id);
        if (encontrado) {
            personaRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException();
    }
}
