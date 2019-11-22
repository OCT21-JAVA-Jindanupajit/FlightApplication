package jbc.oct21.jindanupajit.flightapplication.model.repository;

import jbc.oct21.jindanupajit.flightapplication.model.Airline;
import jbc.oct21.jindanupajit.flightapplication.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    Flight findByAirlineAndFlightNumber(Airline airline, int flightNumber);
}
