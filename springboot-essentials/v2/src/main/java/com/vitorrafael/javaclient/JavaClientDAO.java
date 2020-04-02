package com.vitorrafael.javaclient;

import com.vitorrafael.handler.RestResponseExceptionHandler;
import com.vitorrafael.model.PageableResponse;
import com.vitorrafael.model.Student;
import org.apache.coyote.Response;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JavaClientDAO {
    private  static RestTemplate restTemplateUser = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v2/protected/students")
            .basicAuthentication("vitorrafael", "07042001")
            .errorHandler(new RestResponseExceptionHandler())
            .build();

     private static RestTemplate restTemplateAdmin = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v2/admin/students")
            .basicAuthentication("admin", "admin")
            .errorHandler(new RestResponseExceptionHandler())
            .build();

    {

    }

    public Student findByIdWithObject(long id) {
        Student student = restTemplateUser.getForObject("/{id}", Student.class, id);
        return student;
    }

    public ResponseEntity<Student> findByIdWithResponseEntity(long id) {
        ResponseEntity<Student> studentEntity = restTemplateUser.getForEntity("/{id}", Student.class, id);
        return studentEntity;
    }

    public List<Student> listAllWithoutPageable() {
        ResponseEntity<List<Student>> exchange = restTemplateUser.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {});
        return exchange.getBody();
    }

    public List<Student> listAllWithPageable() {
        ResponseEntity<PageableResponse<Student>> exchange = restTemplateUser.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<PageableResponse<Student>>() {});
        return exchange.getBody().getContent();
    }

    public Student saveWithResponseEntity(Student student) {
        ResponseEntity<Student> exchangePost = restTemplateAdmin.exchange("/", HttpMethod.POST, new HttpEntity<>(student, createJSONHeader()), Student.class);
        return exchangePost.getBody();
    }

    public Student saveWithForObject(Student student) {
        Student studentResponse = restTemplateAdmin.postForObject("/", student, Student.class);
        return studentResponse;
    }

    public Student saveWithForEntity(Student student) {
        ResponseEntity<Student> responseEntity = restTemplateAdmin.postForEntity("/", student, Student.class);
        return responseEntity.getBody();
    }

    private HttpHeaders createJSONHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
