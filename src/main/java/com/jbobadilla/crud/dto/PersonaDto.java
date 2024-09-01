package com.jbobadilla.crud.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonaDto {
    Long id;
    String dni;
    String nombre;
    String apellido;
    String telefono;
    Integer edad;
    Boolean sexo;
}


