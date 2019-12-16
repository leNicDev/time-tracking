package dev.lenic.timetracking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(
        name = "timesheet_entry"
)
public class TimesheetEntry extends DataAudit {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "duration")
    private Long duration;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timesheet_id")
    @JsonBackReference
    private Timesheet timesheet;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimesheetEntry that = (TimesheetEntry) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(timesheet, that.timesheet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, duration, title, description, timesheet);
    }

    @Override
    public String toString() {
        return "TimesheetEntry{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timesheet=" + timesheet +
                '}';
    }

}
