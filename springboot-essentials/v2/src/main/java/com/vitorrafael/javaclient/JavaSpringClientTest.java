package com.vitorrafael.javaclient;

import com.vitorrafael.model.PageableResponse;
import com.vitorrafael.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JavaSpringClientTest {
    public static void main(String[] args) {
        // Create a Rest Template Client
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080/v2/protected/students")
                .basicAuthentication("admin", "admin")
                .build();

        // clientGetExamplesWithoutPageable(restTemplate);
        clientGetWithPageable(restTemplate);
    }

    private static void clientGetWithPageable(RestTemplate restTemplate) {
         // Even though the exchange object says that the sort is UNSORTED the server is returning the content in the way that is asked
        /*
         * TODO: Investigate exchange "sort" issues
         */
        ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/?sort=id,asc&sort=name,desc", HttpMethod.GET, null, new ParameterizedTypeReference<PageableResponse<Student>>() {});
        System.out.println(exchange);
        for(Student student : exchange.getBody()) {
            System.out.println(student.getName());
        }
    }

    private static void clientGetWithoutPageable(RestTemplate restTemplate) {
        // Get the information and insert it into an object
        Student student = restTemplate.getForObject("/{id}", Student.class, 12);
        System.out.println(student.toString());

        // Get the information and insert it into a ResponseEntity
        ResponseEntity<Student> studentEntity = restTemplate.getForEntity("/{id}", Student.class, 12);
        System.out.println(studentEntity);
        System.out.println(studentEntity.getBody());

        // Getting many objects and storing them in an object
        Student[] students = restTemplate.getForObject("/", Student[].class);
        System.out.println(students);

        // Getting many objects with a ResponseEntity
        ResponseEntity<List<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {});
        System.out.println(exchange);
    }
}
