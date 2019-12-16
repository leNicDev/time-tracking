package dev.lenic.timetracking.service;

import dev.lenic.timetracking.model.Project;
import dev.lenic.timetracking.model.request.CreateProjectRequest;

import java.util.List;

public interface ProjectService {

    List<Project> getProjects();
    Project createProject(CreateProjectRequest request);

}
