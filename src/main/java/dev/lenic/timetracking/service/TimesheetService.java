package dev.lenic.timetracking.service;

import dev.lenic.timetracking.model.Timesheet;
import dev.lenic.timetracking.model.TimesheetEntry;
import dev.lenic.timetracking.model.request.CreateTimesheetEntryRequest;
import dev.lenic.timetracking.model.request.CreateTimesheetRequest;

import java.util.List;
import java.util.Optional;

public interface TimesheetService {

    List<Timesheet> getTimesheets();
    Optional<Timesheet> getTimesheetById(Long id);
    Timesheet createTimesheet(CreateTimesheetRequest request);
    TimesheetEntry createTimesheetEntry(CreateTimesheetEntryRequest request);
    Optional<TimesheetEntry> getTimesheetEntryById(Long id);

}
