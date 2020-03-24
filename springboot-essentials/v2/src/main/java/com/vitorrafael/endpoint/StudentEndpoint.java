package com.vitorrafael.endpoint;

import com.vitorrafael.error.CustomErrorType;
import com.vitorrafael.model.Student;
import com.vitorrafael.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

// Annotation of Spring MVC based that adds automatically the @ResponseBody to all methods
// @ResponseBody says that everything returned by a method will be JSON
@RestController
@RequestMapping("students") // From where the endpoint will be accessed
public class StudentEndpoint {
    // Endpoint is the place where the users will access the API
    private DateUtil dateUtil;

    @Autowired // Will inject the dependencies
    public StudentEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(Student.studentsList, HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.GET, path = "/{id}") // {?} -> ? Will be a parameter
    @GetMapping(path="/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
        // @PathVariable recovers the variable
        Student student = new Student();
        student.setId(id);
        int index = Student.studentsList.indexOf(student);
        if(index == -1) {
            return new ResponseEntity<>(new CustomErrorType("Student not found."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Student.studentsList.get(index), HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        // There must be a default constructor to use a POST request
        Student.studentsList.add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.DELETE)
   @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Student student) {
        Student.studentsList.remove(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        Student.studentsList.remove(student);
        Student.studentsList.add(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
