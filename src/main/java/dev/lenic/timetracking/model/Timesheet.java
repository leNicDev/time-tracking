package dev.lenic.timetracking.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(
        name = "timesheet",
        uniqueConstraints = @UniqueConstraint(columnNames = { "title", "start_date", "end_date" })
)
public class Timesheet extends DataAudit {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_uuid")
    private Project project;

    @OneToMany(mappedBy = "timesheet")
    private List<TimesheetEntry> entries;

    public Timesheet() {
        this.entries = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<TimesheetEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<TimesheetEntry> entries) {
        this.entries = entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timesheet timesheet = (Timesheet) o;
        return Objects.equals(id, timesheet.id) &&
                Objects.equals(title, timesheet.title) &&
                Objects.equals(startDate, timesheet.startDate) &&
                Objects.equals(endDate, timesheet.endDate) &&
                Objects.equals(project, timesheet.project) &&
                Objects.equals(entries, timesheet.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, startDate, endDate, project, entries);
    }

    @Override
    public String toString() {
        return "Timesheet{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", project=" + project +
                ", entries=" + entries +
                '}';
    }

}
