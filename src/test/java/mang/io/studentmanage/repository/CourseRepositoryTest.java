package mang.io.studentmanage.repository;

import mang.io.studentmanage.entity.Course;
import mang.io.studentmanage.entity.Student;
import mang.io.studentmanage.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    @Test
    // Pagination
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        Pageable secondPageWithThreeRecords = PageRequest.of(1, 3);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords).getContent();
        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("Courses = " + courses);
        System.out.println("total elements= " + totalPages);

    }
    // Sorting
    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("title").descending()
                        .and(Sort.by("credit"))
        );
        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Courses = "+ courses);
    }

    @Test
    public void printfindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords).getContent();
        System.out.println("courses = " + courses );
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Pross")
                .lastName("Newton")
                .build();

        Student student = Student.builder()
                .firstName("abi")
                .lastName("Singh")
                .emailId("abising@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(7)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}