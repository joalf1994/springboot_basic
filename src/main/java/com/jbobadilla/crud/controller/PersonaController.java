package com.jbobadilla.crud.controller;

import com.jbobadilla.crud.dto.PersonaDto;
import com.jbobadilla.crud.service.impl.PersonaServiceImpl;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/persona")
public class PersonaController {
    private final PersonaServiceImpl personaService;

    PersonaController(PersonaServiceImpl personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public ResponseEntity<PersonaDto> createPersona(@RequestBody PersonaDto personaDto) {
        PersonaDto dto = personaService.createPersona(personaDto);
        return ResponseEntity.ok(dto);
    }

    //read
    @GetMapping
    public ResponseEntity<List<PersonaDto>> getAllPersonas() {
        List<PersonaDto> personaDtoList = personaService.getAllPersonas();
        return ResponseEntity.ok(personaDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> getPersonaById(@PathVariable Long id) {
        PersonaDto dto = personaService.getPersonaById(id);
        return ResponseEntity.ok(dto);
    }

    //update
    @PutMapping("/upd")
    public ResponseEntity<PersonaDto> updatePersona(@RequestBody PersonaDto personaDto) {
        PersonaDto dto = personaService.updatePersona(personaDto);
        return ResponseEntity.ok(dto);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return ResponseEntity.ok().build();
        //return ResponseEntity.noContent().build();
    }
}
