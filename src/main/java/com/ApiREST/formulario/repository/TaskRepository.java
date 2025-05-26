package com.ApiREST.formulario.repository;


import com.ApiREST.formulario.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}