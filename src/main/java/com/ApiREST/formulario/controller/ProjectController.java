package com.ApiREST.formulario.controller;


import com.ApiREST.formulario.entity.Project;
import com.ApiREST.formulario.service.IProjectService;
import com.ApiREST.formulario.util.APIResponse;
import com.ApiREST.formulario.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;


    @GetMapping
    public ResponseEntity<APIResponse<List<Project>>> getAllProjects(){
        List<Project> projects = projectService.findAll();
        return projects.isEmpty()? ResponseUtil.notFound("No se encontraron proyectos"): ResponseUtil.success(projects);

    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponse<Project>> getProjectById(@PathVariable("id") Long id){
        return projectService.exists(id)? ResponseUtil.success(projectService.findById(id)): ResponseUtil.notFound("No se encontró el proyecto con id {0}", id);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Project>> createProject (@RequestBody Project project){
        return projectService.exists(project.getId()) ? ResponseUtil.badRequest("Ya existe un proyecto con id {0}", project.getId()):
        ResponseUtil.success(projectService.save(project));
    }

    @PutMapping
    public ResponseEntity<APIResponse<Project>> updateProject(@RequestBody Project project){
        return projectService.exists(project.getId())? ResponseUtil.success(project): ResponseUtil.badRequest("No existe un proyecto con id {0}", project.getId());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse<Project>> deleteProject (@PathVariable("id") Long id){
        if (projectService.exists(id)) {
            projectService.delete(id);
            return ResponseUtil.successDeleted("Se eliminó el proyecto con el id {0}", id);
        }else{
            return ResponseUtil.badRequest("No se encontró el proyecto con el id {0}", id);
        }
    }
}
