package dev.lenic.timetracking.service;

import dev.lenic.timetracking.exception.CreateResourceException;
import dev.lenic.timetracking.model.Project;
import dev.lenic.timetracking.model.Timesheet;
import dev.lenic.timetracking.model.request.CreateTimesheetRequest;
import dev.lenic.timetracking.repository.ProjectRepository;
import dev.lenic.timetracking.repository.TimesheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultTimesheetService implements TimesheetService {

    private TimesheetRepository timeSheetRepository;
    private ProjectRepository projectRepository;


    public DefaultTimesheetService(TimesheetRepository timeSheetRepository,
                                   ProjectRepository projectRepository) {
        this.timeSheetRepository = timeSheetRepository;
        this.projectRepository = projectRepository;
    }


    @Override
    public List<Timesheet> getTimesheets() {
        return timeSheetRepository.findAll();
    }

    @Override
    public Optional<Timesheet> getTimesheetById(Long id) {
        return timeSheetRepository.findById(id);
    }

    @Override
    public Timesheet createTimesheet(CreateTimesheetRequest request) {
        final Optional<Project> project = projectRepository.findById(request.getProjectId());

        if (project.isEmpty()) {
            throw new CreateResourceException("The referenced project does not exist");
        }

        final Timesheet timeSheet = new Timesheet();
        timeSheet.setTitle(request.getTitle());
        timeSheet.setStartDate(request.getStartDate());
        timeSheet.setEndDate(request.getEndDate());
        timeSheet.setProject(project.get());

        return timeSheetRepository.save(timeSheet);
    }

}
