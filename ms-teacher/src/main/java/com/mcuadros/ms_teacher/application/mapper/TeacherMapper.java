package com.mcuadros.ms_teacher.application.mapper;

import com.mcuadros.ms_teacher.application.dto.request.TeacherRequest;
import com.mcuadros.ms_teacher.application.dto.response.TeacherResponse;
import com.mcuadros.ms_teacher.domain.entity.Teacher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TeacherMapper {

    public Teacher toTeacher(TeacherRequest teacherRequest) {
        return Teacher.builder()
                .name(teacherRequest.getName())
                .lastName(teacherRequest.getLastName())
                .documentType(teacherRequest.getDocumentType())
                .documentNumber(teacherRequest.getDocumentNumber())
                .cellPhone(teacherRequest.getCellPhone())
                .email(teacherRequest.getEmail())
                .birthDate(teacherRequest.getBirthDate())
                .address(teacherRequest.getAddress())
                .reference(teacherRequest.getReference())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .active(true)
                .build();
    }

    public TeacherResponse toTeacherResponse(Teacher teacher) {
        return TeacherResponse.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .lastName(teacher.getLastName())
                .documentType(teacher.getDocumentType())
                .documentNumber(teacher.getDocumentNumber())
                .cellPhone(teacher.getCellPhone())
                .email(teacher.getEmail())
                .birthDate(teacher.getBirthDate())
                .address(teacher.getAddress())
                .reference(teacher.getReference())
                .createdAt(teacher.getCreatedAt())
                .updatedAt(teacher.getUpdatedAt())
                .build();
    }

    public void updateTeacherFromRequest(TeacherRequest teacherRequest, Teacher teacher) {
        teacher.setName(teacherRequest.getName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setDocumentType(teacherRequest.getDocumentType());
        teacher.setDocumentNumber(teacherRequest.getDocumentNumber());
        teacher.setCellPhone(teacherRequest.getCellPhone());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setBirthDate(teacherRequest.getBirthDate());
        teacher.setAddress(teacherRequest.getAddress());
        teacher.setReference(teacherRequest.getReference());
        teacher.setUpdatedAt(LocalDateTime.now());
    }

}
