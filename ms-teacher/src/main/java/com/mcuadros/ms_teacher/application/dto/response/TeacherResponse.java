package com.mcuadros.ms_teacher.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse {

    private Integer id;
    private String name;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private String cellPhone;
    private String email;
    private LocalDate birthDate;
    private String address;
    private String reference;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
