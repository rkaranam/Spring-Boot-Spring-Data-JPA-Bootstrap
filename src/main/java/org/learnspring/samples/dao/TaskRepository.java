package org.learnspring.samples.dao;

import org.learnspring.samples.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
