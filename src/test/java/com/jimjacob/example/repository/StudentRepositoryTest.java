package com.jimjacob.example.repository;

import com.jimjacob.example.entity.StudentEntity;
import com.jimjacob.example.entity.TeacherEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:unit-test.properties", properties = "spring.main.banner-mode=off")
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    @Sql(value = "/sql/student_data_setup.sql")
    @Sql(value = "/sql/data_cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void expect_student_and_teacher_data_retrieved_for_valid_student_id() {
        StudentEntity student = studentRepository.findById("cf43c22a-84b5-11e9-bc42-526af7764f64").orElse(null);
        assertThat(student.getId(), is("cf43c22a-84b5-11e9-bc42-526af7764f64"));
        assertThat(student.getFirstName(), is("Stephen"));
        assertThat(student.getLastName(), is("Hawking"));
        assertThat(student.getTeacher().getId(), is("1559127c-84b4-11e9-bc42-526af7764f64"));
        assertThat(student.getTeacher().getFirstName(), is("Helen"));
        assertThat(student.getTeacher().getLastName(), is("Keller"));
    }

    @Test
    @Sql(value = "/sql/teacher_data_setup.sql")
    @Sql(value = "/sql/data_cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void expect_student_data_inserted_for_valid_data() {
        TeacherEntity teacher = teacherRepository.findById("ae59127c-84b4-11e9-bc42-526af7764f64").orElse(null);
        StudentEntity student = new StudentEntity("Jim", "Jacob", teacher);
        StudentEntity savedStudent = studentRepository.save(student);
        StudentEntity retrievedStudent = studentRepository.findById(savedStudent.getId()).orElse(null);
        assertThat(retrievedStudent.getId(), is(savedStudent.getId()));
        assertThat(retrievedStudent.getFirstName(), is("Jim"));
        assertThat(retrievedStudent.getLastName(), is("Jacob"));
        assertThat(savedStudent.getTeacher().getId(), is("ae59127c-84b4-11e9-bc42-526af7764f64"));
        assertThat(savedStudent.getTeacher().getFirstName(), is("Marie"));
        assertThat(savedStudent.getTeacher().getLastName(), is("Curie"));
    }
}
