package com.mcuadros.ms_teacher.infrastructure.rest;

import com.mcuadros.ms_teacher.application.dto.request.TeacherRequest;
import com.mcuadros.ms_teacher.application.dto.response.TeacherResponse;
import com.mcuadros.ms_teacher.domain.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/all")
    public Flux<TeacherResponse> findAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @GetMapping("/active")
    public Flux<TeacherResponse> findActiveTeachers() {
        return teacherService.findActiveTeachers();
    }

    @GetMapping("/inactive")
    public Flux<TeacherResponse> findInactiveTeachers() {
        return teacherService.findInactiveTeachers();
    }

    @GetMapping("/{id}")
    public Mono<TeacherResponse> findTeacherById(@PathVariable Integer id) {
        return teacherService.findTeacherById(id);
    }

    @PostMapping("/create")
    public Mono<TeacherResponse> createTeacher(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.createTeacher(teacherRequest);
    }

    @PostMapping("/create/all")
    public Flux<TeacherResponse> createAllTeachers(@RequestBody Flux<TeacherRequest> teacherRequests) {
        return teacherService.createAllTeachers(teacherRequests);
    }

    @PutMapping("{id}")
    public Mono<TeacherResponse> updateTeacher(@PathVariable Integer id, @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacher(id, teacherRequest);
    }

    @PatchMapping("{id}")
    public Mono<Void> activateTeacher(@PathVariable Integer id) {
        return teacherService.activateTeacher(id);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deactivateTeacher(@PathVariable Integer id) {
        return teacherService.deactivateTeacher(id);
    }

}
