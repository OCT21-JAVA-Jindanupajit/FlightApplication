package jbc.oct21.jindanupajit.flightapplication.model.repository;

import jbc.oct21.jindanupajit.flightapplication.model.Fare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FairRepository extends CrudRepository<Fare, Long> {
}
