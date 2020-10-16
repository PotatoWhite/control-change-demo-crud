package me.potato.controlchange.demo.crud.entities;

import me.potato.controlchange.demo.crud.store.CourseRepository;
import me.potato.controlchange.demo.crud.store.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(properties = "spring.config.location=classpath:/application-test.yml")
class StudentTest {

  @Autowired
  CourseRepository courseRepository;

  @Autowired
  StudentRepository studentRepository;

  @Test
  @Transactional
  public void crud() {
    var ai = courseRepository.save(new Course("AI", 3));
    var dt = courseRepository.save(new Course("DT", 2));

    var hong = studentRepository.save(new Student("홍길동", "red@gaagle.com"));
    var lim  = studentRepository.save(new Student("임꺽정", "lim@gaagle.com"));

    hong.enroll(ai);
    hong.enroll(dt);
    lim.enroll(dt);

    Student savedHong = studentRepository.save(hong);
    Student saveLim = studentRepository.save(lim);

    Optional<Student> byId1 = studentRepository.findById(hong.getId());
    assertEquals(true, byId1.isPresent());
    assertEquals(true, byId1.get().getEmail().equals("red@gaagle.com"));
    List<Enrollment> enrollments1 = byId1.get().getEnrollments();
    enrollments1.stream().forEach(enrollment -> assertEquals(true, savedHong.getEnrollments().contains(enrollment)));


    Optional<Student> byId2 = studentRepository.findById(lim.getId());
    assertEquals(true, byId2.isPresent());
    assertEquals(true, byId2.get().getEmail().equals("lim@gaagle.com"));
    byId2.get().getEnrollments().stream().forEach(enrollment -> assertEquals(true, saveLim.getEnrollments().contains(enrollment)));
  }
}