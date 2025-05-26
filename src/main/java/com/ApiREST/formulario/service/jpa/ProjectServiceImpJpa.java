package com.ApiREST.formulario.service.jpa;


import com.ApiREST.formulario.entity.Project;
import com.ApiREST.formulario.repository.ProjectRepository;
import com.ApiREST.formulario.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpJpa implements IProjectService {

    @Autowired
    private ProjectRepository repo;

    @Override
    public List<Project> findAll(){
        return repo.findAll();
    }

    @Override
    public Project findById (Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean exists (Long id){
        return id != null && repo.existsById(id);
    }

    @Override
    public Project save (Project project){
        return repo.save(project);
    }

    @Override
    public void delete (Long id){
        repo.deleteById(id);
    }
}
