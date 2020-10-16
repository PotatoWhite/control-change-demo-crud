package me.potato.controlchange.demo.crud.store;

import me.potato.controlchange.demo.crud.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
