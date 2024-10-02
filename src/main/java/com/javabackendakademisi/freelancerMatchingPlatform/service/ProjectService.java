package com.javabackendakademisi.freelancerMatchingPlatform.service;

import com.javabackendakademisi.freelancerMatchingPlatform.exception.ResourceNotFoundException;
import com.javabackendakademisi.freelancerMatchingPlatform.model.Project;
import com.javabackendakademisi.freelancerMatchingPlatform.model.request.ProjectRequestDTO;
import com.javabackendakademisi.freelancerMatchingPlatform.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    //Proje oluşturma
    public Project createProject(Project project) {
        // Proje açıklaması ve bütçe kontrolü
        if (project.getDescription() == null || project.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Proje açıklaması boş olamaz.");
        }
        /*if (project.getBudget() <= 0) {
            throw new IllegalArgumentException("Proje bütçesi negatif olamaz.");
        }*/
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bu ID ile proje bulunamadı: " + id));
    }

    public Project updateProject(Long id, Project updatedProject) {
        Project existingProject = getProjectById(id);
        existingProject.setTitle(updatedProject.getTitle());
        existingProject.setDescription(updatedProject.getDescription());
        existingProject.setBudget(updatedProject.getBudget());
        existingProject.setStatus(updatedProject.getStatus());
        return projectRepository.save(existingProject);
    }

    public void deleteProject(Long id) {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }
}
