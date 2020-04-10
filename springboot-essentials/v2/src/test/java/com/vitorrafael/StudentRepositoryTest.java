package com.vitorrafael;

import com.vitorrafael.model.Student;
import com.vitorrafael.repository.StudentRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// @RunWith -> With what are we going to execute this class
@RunWith(SpringRunner.class) // SpringRunner is a class used to execute Spring with JUnit
@DataJpaTest // Database configurations
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) -> Will use the database
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Rule // Test Rule
     public ExpectedException thrown = ExpectedException.none();

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void createShouldPersistData() {
        Student student = new Student("Vitor", "vitorrafael07@gmail.com");
        this.studentRepository.save(student);

        assertThat(student.getId()).isNotNull();
        assertThat(student.getName()).isEqualTo("Vitor");
        assertThat(student.getEmail()).isEqualTo("vitorrafael07@gmail.com");
    }

    @Test
    public void deleteShouldRemoveData() {
        Student student = new Student("Vitor", "vitorrafael07@gmail.com");
        this.studentRepository.save(student);
        this.studentRepository.delete(student);

        assertThat(this.studentRepository.findById(student.getId())).isEmpty();
    }

    @Test
    public void updateShouldChangeAndPersistData() {
        Student student = new Student("Vitor", "vitorrafael07@gmail.com");

        this.studentRepository.save(student);

        student.setName("Vitor Rafael");
        student.setEmail("vitorrafaelsilveira@gmail.com");

        this.studentRepository.save(student);

        student = this.studentRepository.findById(student.getId()).get();

        assertThat(student.getName()).isEqualTo("Vitor Rafael");
        assertThat(student.getEmail()).isEqualTo("vitorrafaelsilveira@gmail.com");
        assertThat(student.getName()).isNotEqualTo("Vitor");
        assertThat(student.getEmail()).isNotEqualTo("vitorafael07@gmail.com");
    }

    @Test
    public void findByNameIgnoreCaseShouldIgnoreCase() {
        Student student = new Student("Vitor Rafael", "vitorrafael@gmail.com");
        Student student1 = new Student("Vitor", "vitorrafael2@gmail.com");

        this.studentRepository.save(student);
        this.studentRepository.save(student1);

        List<Student> studentList = this.studentRepository.findByNameIgnoreCaseContaining("VITOR");

        assertThat(studentList.size()).isEqualTo(2);
    }

    @Test
    public void createWhenNameIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Field  name must not be empty");

        Student student = new Student(null, "vitorrafael@gmail.com");
        studentRepository.save(student);
        entityManager.flush();
    }


    @Test
    public void createWhenEmailIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Field email must not be empty");

        Student student = new Student("Vitor Rafael", null);
        studentRepository.save(student);
        entityManager.flush();
    }

    @Test
    public void createWhenEmailIsNotValidThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Email not valid");

        Student student = new Student("Vitor Rafael", "vitorrafael");
        studentRepository.save(student);

        entityManager.flush();
    }
}

