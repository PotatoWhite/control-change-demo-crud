package me.potato.controlchange.demo.crud.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Disenrollment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "student_id")
  private Student student;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "course_id")
  private Course course;

  private LocalDateTime requested;

  private String comment;
}
