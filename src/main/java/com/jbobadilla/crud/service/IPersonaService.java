package com.jbobadilla.crud.service;

import com.jbobadilla.crud.dto.PersonaDto;

import java.util.List;

public interface IPersonaService {
    //create
    public PersonaDto createPersona(PersonaDto personaDto);

    //read
    public List<PersonaDto> getAllPersonas();
    public PersonaDto getPersonaById(Long id);

    //update
    public PersonaDto updatePersona(PersonaDto personaDto);

    //delete
    public void deletePersona(Long id);


}
