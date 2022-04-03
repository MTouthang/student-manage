package mang.io.studentmanage.repository;

import mang.io.studentmanage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);
//    public List<Student> finByLastNameNotNull();
//    public List<Student> findByGuardianName(String guardianName);
//    public Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL query
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentNameByEmailAddress(String emailId);

}
