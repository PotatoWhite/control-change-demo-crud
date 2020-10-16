package me.potato.controlchange.demo.crud.store;

import me.potato.controlchange.demo.crud.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
