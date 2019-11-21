package jbc.oct21.jindanupajit.flightapplication.model.repository;

import jbc.oct21.jindanupajit.flightapplication.model.FlightSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightScheduleRepository extends CrudRepository<FlightSchedule, Long> {
}
