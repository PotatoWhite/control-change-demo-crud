package me.potato.controlchange.demo.crud.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Version
  private Long version;

  private LocalDateTime created = LocalDateTime.now();
  @NonNull
  private String        name;
  @NonNull
  private String        email;

  @OneToMany( mappedBy = "student")
  private List<Enrollment> enrollments = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
  private List<Disenrollment> disenrollments = new ArrayList<>();

  public boolean enroll(Course course) {
    Enrollment newEnrollment = new Enrollment(this, course);
    enrollments.stream().filter((enrollment) -> !enrollment.getCourse().equals(course)).map(enrollment -> course.addEnrollment(newEnrollment));
    return enrollments.add(newEnrollment);
  }

}
