package dev.lenic.timetracking.service;

import dev.lenic.timetracking.model.Project;
import dev.lenic.timetracking.model.request.CreateProjectRequest;
import dev.lenic.timetracking.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProjectService implements ProjectService {

    private ProjectRepository projectRepository;

    public DefaultProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project createProject(CreateProjectRequest request) {
        final Project project = new Project();
        project.setProjectNo(request.getProjectNo());
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        return projectRepository.save(project);
    }

}
