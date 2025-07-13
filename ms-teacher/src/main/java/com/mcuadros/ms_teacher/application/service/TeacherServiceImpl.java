package com.mcuadros.ms_teacher.application.service;

import com.mcuadros.ms_teacher.application.dto.request.TeacherRequest;
import com.mcuadros.ms_teacher.application.dto.response.TeacherResponse;
import com.mcuadros.ms_teacher.application.mapper.TeacherMapper;
import com.mcuadros.ms_teacher.domain.entity.Teacher;
import com.mcuadros.ms_teacher.domain.service.TeacherService;
import com.mcuadros.ms_teacher.infrastructure.persistence.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public Flux<TeacherResponse> findAllTeachers() {
        return teacherRepository.findAllByOrderByIdDesc()
                .map(teacherMapper::toTeacherResponse);
    }

    @Override
    public Flux<TeacherResponse> findActiveTeachers() {
        return teacherRepository.findByActiveOrderByIdDesc(true)
                .map(teacherMapper::toTeacherResponse);
    }

    @Override
    public Flux<TeacherResponse> findInactiveTeachers() {
        return teacherRepository.findByActiveOrderByIdDesc(false)
                .map(teacherMapper::toTeacherResponse);
    }

    @Override
    public Mono<TeacherResponse> findTeacherById(Integer id) {
        return teacherRepository.findById(id)
                .map(teacherMapper::toTeacherResponse);
    }

    @Override
    public Mono<TeacherResponse> createTeacher(TeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.toTeacher(teacherRequest);
        return teacherRepository.save(teacher)
                .map(teacherMapper::toTeacherResponse);
    }

    @Override
    public Flux<TeacherResponse> createAllTeachers(Flux<TeacherRequest> teacherRequests) {
        return teacherRequests
                .map(teacherMapper::toTeacher)
                .collectList()
                .flatMapMany(teacherRepository::saveAll)
                .map(teacherMapper::toTeacherResponse);
    }

    @Override
    public Mono<TeacherResponse> updateTeacher(Integer id, TeacherRequest teacherRequest) {
        return teacherRepository.findById(id)
                .flatMap(teacher -> {
                    teacherMapper.updateTeacherFromRequest(teacherRequest, teacher);
                    return teacherRepository.save(teacher);
                })
                .map(teacherMapper::toTeacherResponse);
    }

    @Override
    public Mono<Void> activateTeacher(Integer id) {
        return teacherRepository.findById(id)
                .flatMap(teacher -> {
                    teacher.setActive(true);
                    return teacherRepository.save(teacher);
                })
                .then();
    }

    @Override
    public Mono<Void> deactivateTeacher(Integer id) {
        return teacherRepository.findById(id)
                .flatMap(teacher -> {
                    teacher.setActive(false);
                    return teacherRepository.save(teacher);
                })
                .then();
    }

}
