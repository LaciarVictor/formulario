package com.ApiREST.formulario.service;

import java.util.List;
import com.ApiREST.formulario.entity.Project;

public interface IProjectService {

    public List<Project> findAll();

    public Project findById(Long id);

    public boolean exists (Long id);

    public Project save (Project project);

    public void delete (Long id);
}
