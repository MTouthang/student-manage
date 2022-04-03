package mang.io.studentmanage.repository;

import mang.io.studentmanage.entity.Course;
import mang.io.studentmanage.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println("Courses: " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Selina")
                .lastName("khoirom")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

}