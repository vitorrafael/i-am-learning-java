package com.vitorrafael.awesome.endpoint;

import com.vitorrafael.awesome.model.Student;
import com.vitorrafael.awesome.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

// Annotation of Spring MVC based that adds automatically the @ResponseBody to all methods
// @ResponseBody says that everything returned by a method will be JSON
@RestController
@RequestMapping("student") // From where the endpoint will be accessed
public class StudentEndpoint {
    // Endpoint is the place where the users will access the API

    @Autowired // Will inject the dependencies
    private DateUtil dateUtil;

    // Method used and the map
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Student> listAll() {
        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return asList(new Student("Vitor"), new Student("Rafaela"));
    }
}
