package mang.io.studentmanage.repository;

import mang.io.studentmanage.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
