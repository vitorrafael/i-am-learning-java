package com.vitorrafael.endpoint;

import com.vitorrafael.error.ResourceNotFoundException;
import com.vitorrafael.model.Student;
import com.vitorrafael.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
    public ResponseEntity<?> listAll(Pageable pageable) {
        // Pageable is an interface used to paginate that contains all features from a paginated endpoint
        return new ResponseEntity<>(DAO.findAll(pageable), HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.GET, path = "/{id}") // {?} -> ? Will be a parameter
    @GetMapping(path="/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        // @PathVariable recovers the variable
        verifyIfStudentExists(id);
        Student  student = DAO.findById(id).get();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(path="/name/{name}")
    public ResponseEntity<?> getStudentsByName(@PathVariable String name) {
        return new ResponseEntity<>(DAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.POST)
    // @Transactional -> Transform into a transaction
    @PostMapping
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<?> save(@Valid @RequestBody Student student) {
        // There must be a default constructor to use a POST request
        return new ResponseEntity<>(DAO.save(student), HttpStatus.CREATED);
    }

    // @RequestMapping(method = RequestMethod.DELETE)
   @DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long  id) {
       verifyIfStudentExists(id);
       DAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        // The update will be automatically done
        verifyIfStudentExists(student.getId());
        DAO.save(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private void verifyIfStudentExists(Long id) {
        if(!DAO.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Student not found for Id: " + id);
        }
    }
}

