package me.potato.controlchange.demo.crud.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Enrollment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @ManyToOne()
  @JoinColumn(name = "student_id")
  private Student student;

  @NonNull
  @ManyToOne()
  @JoinColumn(name = "course_id")
  private Course course;

  private Grade grade;
}
