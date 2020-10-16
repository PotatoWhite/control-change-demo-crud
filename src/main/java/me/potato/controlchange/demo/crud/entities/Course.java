package me.potato.controlchange.demo.crud.entities;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NonNull
  @Column(unique = true)
  private String name;
  @NonNull
  private Integer stamps;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "course")
  Set<Enrollment> enrollments = new LinkedHashSet<>();

  public int addEnrollment(Enrollment enrollment) {
    if (!enrollments.contains(enrollment))
      enrollments.add(enrollment);
    return enrollments.size();
  }

}
