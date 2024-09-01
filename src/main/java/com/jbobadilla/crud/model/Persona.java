package com.jbobadilla.crud.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 8)
    String dni;
    @Column(nullable = false, length = 100)
    String nombre;
    @Column(nullable = false, length = 100)
    String apellido;
    @Column(nullable = false, length = 12)
    String telefono;
    Integer edad;
    @Column(nullable = false)
    Boolean sexo;
}
