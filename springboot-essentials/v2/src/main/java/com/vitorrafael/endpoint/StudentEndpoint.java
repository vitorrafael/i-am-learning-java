package com.vitorrafael.endpoint;

import com.vitorrafael.error.CustomErrorType;
import com.vitorrafael.model.Student;
import com.vitorrafael.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Annotation of Spring MVC based that adds automatically the @ResponseBody to all methods
// @ResponseBody says that everything returned by a method will be JSON
@RestController
@RequestMapping("students") // From where the endpoint will be accessed
public class StudentEndpoint {
    private final StudentRepository DAO;

    @Autowired // Will do the Dependency Injection
    public StudentEndpoint(StudentRepository DAO) {
        this.DAO = DAO;
    }

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(DAO.findAll(), HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.GET, path = "/{id}") // {?} -> ? Will be a parameter
    @GetMapping(path="/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        // @PathVariable recovers the variable
        Student student = DAO.findById(id).get();
        if(student == null ) {
            return new ResponseEntity<>(new CustomErrorType("Student not found."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        // There must be a default constructor to use a POST request
        return new ResponseEntity<>(DAO.save(student), HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.DELETE)
   @DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long  id) {
        DAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        // The update will be automatically done
        DAO.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

