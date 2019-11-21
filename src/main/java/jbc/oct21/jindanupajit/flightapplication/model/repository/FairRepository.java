package jbc.oct21.jindanupajit.flightapplication.model.repository;

import jbc.oct21.jindanupajit.flightapplication.model.Fair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FairRepository extends CrudRepository<Fair, Long> {
}
