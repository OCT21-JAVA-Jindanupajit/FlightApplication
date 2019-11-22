package jbc.oct21.jindanupajit.flightapplication.model.repository;

import jbc.oct21.jindanupajit.flightapplication.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {
    Airport findByIataCode(String iataCode);
}
