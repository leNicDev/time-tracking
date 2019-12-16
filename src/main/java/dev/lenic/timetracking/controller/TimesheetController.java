package dev.lenic.timetracking.controller;

import dev.lenic.timetracking.model.Timesheet;
import dev.lenic.timetracking.model.request.CreateTimesheetRequest;
import dev.lenic.timetracking.service.TimesheetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {

    private TimesheetService timesheetService;

    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping
    public List<Timesheet> getTimesheets() {
        return timesheetService.getTimesheets();
    }

    @GetMapping("/{id}")
    public Optional<Timesheet> getTimesheetById(@PathVariable("id") Long id) {
        return timesheetService.getTimesheetById(id);
    }

    @PostMapping
    public Timesheet createTimesheet(@RequestBody CreateTimesheetRequest request) {
        return timesheetService.createTimesheet(request);
    }

}
