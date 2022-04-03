package mang.io.studentmanage.repository;

import mang.io.studentmanage.entity.Guardian;
import mang.io.studentmanage.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("mangio@gmail.com")
                .firstName("mang")
                .lastName("Touthang")
//                .guardianName("Nikil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("888888888929228")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Nikhil")
                .email("nikhil@gmail.com")
                .mobile("8983983857")
                .build();

        Student student = Student.builder()
                .firstName("Mang")
                .emailId("mangio2@gmail.com")
                .lastName("Touthang")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList = "+ studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("mang");
        System.out.println("Students name" + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("ma");
        System.out.println("Students name" + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> student = studentRepository.findByGuardianName("Nikhil");
        System.out.println("Student = " + student);
    }

}