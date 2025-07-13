package com.mcuadros.ms_teacher.domain.service;

import com.mcuadros.ms_teacher.application.dto.request.TeacherRequest;
import com.mcuadros.ms_teacher.application.dto.response.TeacherResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeacherService {

    Flux<TeacherResponse> findAllTeachers();
    Flux<TeacherResponse> findActiveTeachers();
    Flux<TeacherResponse> findInactiveTeachers();
    Mono<TeacherResponse> findTeacherById(Integer id);
    Mono<TeacherResponse> createTeacher(TeacherRequest teacherRequest);
    Flux<TeacherResponse> createAllTeachers(Flux<TeacherRequest> teacherRequests);
    Mono<TeacherResponse> updateTeacher(Integer id, TeacherRequest teacherRequest);
    Mono<Void> activateTeacher(Integer id);
    Mono<Void> deactivateTeacher(Integer id);

}
