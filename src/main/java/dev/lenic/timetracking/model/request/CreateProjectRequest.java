package dev.lenic.timetracking.model.request;

import javax.validation.constraints.NotEmpty;

public class CreateProjectRequest {

    @NotEmpty
    private String projectNo;
    @NotEmpty
    private String name;
    private String description;


    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
