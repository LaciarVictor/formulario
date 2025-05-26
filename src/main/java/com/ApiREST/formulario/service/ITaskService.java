package com.ApiREST.formulario.service;

import java.util.List;
import com.ApiREST.formulario.entity.Task;

public interface ITaskService {

    public List<Task> findAll();

    public Task findById(Long id);

    public boolean exists (Long id);

    public Task save (Task project);

    public void delete (Long id);
}