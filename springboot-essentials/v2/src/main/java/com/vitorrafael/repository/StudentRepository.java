package com.vitorrafael.repository;

import com.vitorrafael.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

// CrudRepository<Entity, Identification>
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    // PagingAndSortingRepository is an interface that allows pagination and extends from CrudRepository
    List<Student> findByNameIgnoreCaseContaining(String name);
}
