package dev.lenic.timetracking.service;

import dev.lenic.timetracking.exception.CreateResourceException;
import dev.lenic.timetracking.model.Project;
import dev.lenic.timetracking.model.Timesheet;
import dev.lenic.timetracking.model.TimesheetEntry;
import dev.lenic.timetracking.model.request.CreateTimesheetEntryRequest;
import dev.lenic.timetracking.model.request.CreateTimesheetRequest;
import dev.lenic.timetracking.repository.ProjectRepository;
import dev.lenic.timetracking.repository.TimesheetEntryRepository;
import dev.lenic.timetracking.repository.TimesheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultTimesheetService implements TimesheetService {

    private TimesheetRepository timeSheetRepository;
    private TimesheetEntryRepository timesheetEntryRepository;
    private ProjectRepository projectRepository;


    public DefaultTimesheetService(TimesheetRepository timeSheetRepository,
                                   TimesheetEntryRepository timesheetEntryRepository,
                                   ProjectRepository projectRepository) {
        this.timeSheetRepository = timeSheetRepository;
        this.timesheetEntryRepository = timesheetEntryRepository;
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

    @Override
    public TimesheetEntry createTimesheetEntry(CreateTimesheetEntryRequest request) {
        final Optional<Timesheet> timesheet = getTimesheetById(request.getTimesheetId());

        if (timesheet.isEmpty()) {
            throw new CreateResourceException("The referenced timesheet does not exist");
        }

        final TimesheetEntry entry = new TimesheetEntry();
        entry.setStartDate(request.getStartDate());
        entry.setDuration(request.getDuration());
        entry.setTitle(request.getTitle());
        entry.setDescription(request.getDescription());
        entry.setTimesheet(timesheet.get());

        return timesheetEntryRepository.save(entry);
    }

    @Override
    public Optional<TimesheetEntry> getTimesheetEntryById(Long id) {
        return timesheetEntryRepository.findById(id);
    }

}
