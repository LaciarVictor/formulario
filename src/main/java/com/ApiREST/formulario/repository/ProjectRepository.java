package com.ApiREST.formulario.repository;


import com.ApiREST.formulario.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByDueDateNotNullOrderByDueDate();

    List<Project> findByDueDateNull();

    List<Project> findByDueDateNotNullAndDoneTrueOrderByDueDate();

    List<Project> findByDueDateNullAndDoneTrue();

    List<Project> findByDueDateNotNullAndDoneFalseOrderByDueDate();

    List<Project> findByDueDateNullAndDoneFalse();

}
