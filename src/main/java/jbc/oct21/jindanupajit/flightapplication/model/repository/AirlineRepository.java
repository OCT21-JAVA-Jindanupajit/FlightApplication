package jbc.oct21.jindanupajit.flightapplication.model.repository;

import jbc.oct21.jindanupajit.flightapplication.model.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Long> {
}
