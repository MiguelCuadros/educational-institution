package com.mcuadros.ms_teacher.infrastructure.persistence.repository;

import com.mcuadros.ms_teacher.domain.entity.Teacher;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TeacherRepository extends ReactiveCrudRepository<Teacher, Integer> {

    Flux<Teacher> findAllByOrderByIdDesc();
    Flux<Teacher> findByActiveOrderByIdDesc(Boolean active);

}
