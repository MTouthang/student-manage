package mang.io.studentmanage.repository;

import mang.io.studentmanage.entity.Course;
import mang.io.studentmanage.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){
        Course courseDB = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .title("Java")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Manos")
                .lastName("Singh")
                //.courses(List.of(courseDB, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}