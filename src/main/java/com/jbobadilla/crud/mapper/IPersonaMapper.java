package com.jbobadilla.crud.mapper;

import com.jbobadilla.crud.dto.PersonaDto;
import com.jbobadilla.crud.model.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPersonaMapper {
    Persona mapToPersona(PersonaDto personaDto);
    PersonaDto mapToPersonaDto(Persona persona);
    List<Persona> mapToPersonaList(List<PersonaDto> personaDtoList);
    List<PersonaDto> mapToPersonaDtoList(List<Persona> personaList);
}
