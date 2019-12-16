package dev.lenic.timetracking.repository;

import dev.lenic.timetracking.model.TimesheetEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetEntryRepository extends JpaRepository<TimesheetEntry, Long> {
}
