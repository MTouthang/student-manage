package mang.io.studentmanage.repository;

import mang.io.studentmanage.entity.Course;
import mang.io.studentmanage.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course =
                Course.builder()
                        .title("Programming")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.geekforgek.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials =
                courseMaterialRepository.findAll();
        System.out.println("CourseMaterials: " + courseMaterials);
    }

}