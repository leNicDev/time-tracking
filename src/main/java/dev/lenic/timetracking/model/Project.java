package dev.lenic.timetracking.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(
        name = "project",
        indexes = {
                @Index(name = "PROJECT_NO_INDEX", columnList = "project_no", unique = true),
                @Index(name = "PROJECT_NAME_INDEX", columnList = "name", unique = true)
        }
)
public class Project extends DataAudit {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "project_no")
    private String projectNo;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(projectNo, project.projectNo) &&
                Objects.equals(name, project.name) &&
                Objects.equals(description, project.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectNo, name, description);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectNo='" + projectNo + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
