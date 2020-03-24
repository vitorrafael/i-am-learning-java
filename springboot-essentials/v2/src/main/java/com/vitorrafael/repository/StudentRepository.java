package com.vitorrafael.repository;

import com.vitorrafael.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// CrudRepository<Entity, Identification>
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByName(String name);
}
