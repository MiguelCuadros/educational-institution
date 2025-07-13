package com.mcuadros.ms_teacher.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("edu.PROFESOR")
public class Teacher {

    @Id
    @Column("ID")
    private Integer id;
    @Column("NOMBRE")
    private String name;
    @Column("APELLIDOS")
    private String lastName;
    @Column("TIPO_DOCUMENTO")
    private String documentType;
    @Column("NUMERO_DOCUMENTO")
    private String documentNumber;
    @Column("CELULAR")
    private String cellPhone;
    @Column("CORREO")
    private String email;
    @Column("FECHA_NACIMIENTO")
    private LocalDate birthDate;
    @Column("DIRECCION")
    private String address;
    @Column("REFERENCIA")
    private String reference;
    @Column("FECHA_CREACION")
    private LocalDateTime createdAt;
    @Column("FECHA_MODIFICACION")
    private LocalDateTime updatedAt;
    @Column("ACTIVO")
    private Boolean active;

}
