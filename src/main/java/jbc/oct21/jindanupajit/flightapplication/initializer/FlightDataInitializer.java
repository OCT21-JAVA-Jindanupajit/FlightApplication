package jbc.oct21.jindanupajit.flightapplication.initializer;

import jbc.oct21.jindanupajit.flightapplication.model.Airline;
import jbc.oct21.jindanupajit.flightapplication.model.Airport;
import jbc.oct21.jindanupajit.flightapplication.model.Flight;
import jbc.oct21.jindanupajit.flightapplication.model.repository.AirlineRepository;
import jbc.oct21.jindanupajit.flightapplication.model.repository.AirportRepository;
import jbc.oct21.jindanupajit.flightapplication.model.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FlightDataInitializer implements CommandLineRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    AirportRepository airportRepository;

    @Override
    @Transactional
    public void run(String... args)  {
        if (flightRepository.count() > 0)
            return;

        if (airportRepository.count() == 0)
            return;

        if (airlineRepository.count() == 0)
            return;

        Airport BKK = airportRepository.findByIataCode("BKK");
        Airport IAD = airportRepository.findByIataCode("IAD");
        Airport ICN = airportRepository.findByIataCode("ICN");
        Airport DCA = airportRepository.findByIataCode("DCA");
        Airport SFO = airportRepository.findByIataCode("SFO");

        Airline TG = airlineRepository.findByIataCode("TG");
        Airline KE = airlineRepository.findByIataCode("KE");
        Airline UA = airlineRepository.findByIataCode("UA");

        flightRepository.save(new Flight(TG,25, BKK, IAD));
        flightRepository.save(new Flight(TG,26, IAD, BKK));
        flightRepository.save(new Flight(KE,4433, ICN, IAD));
        flightRepository.save(new Flight(KE,4434, IAD, ICN));
        flightRepository.save(new Flight(UA,1210, SFO, DCA));
        flightRepository.save(new Flight(UA,1211, DCA, SFO));

    }
}
