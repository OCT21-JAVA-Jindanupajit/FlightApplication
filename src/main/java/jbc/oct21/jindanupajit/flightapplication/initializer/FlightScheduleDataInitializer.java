package jbc.oct21.jindanupajit.flightapplication.initializer;

import jbc.oct21.jindanupajit.flightapplication.model.Airline;
import jbc.oct21.jindanupajit.flightapplication.model.Airport;
import jbc.oct21.jindanupajit.flightapplication.model.Flight;
import jbc.oct21.jindanupajit.flightapplication.model.FlightSchedule;
import jbc.oct21.jindanupajit.flightapplication.model.repository.AirlineRepository;
import jbc.oct21.jindanupajit.flightapplication.model.repository.AirportRepository;
import jbc.oct21.jindanupajit.flightapplication.model.repository.FlightRepository;
import jbc.oct21.jindanupajit.flightapplication.model.repository.FlightScheduleRepository;
import jbc.oct21.jindanupajit.flightapplication.util.Casting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FlightScheduleDataInitializer implements CommandLineRunner {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    FlightScheduleRepository flightScheduleRepository;

    @Override
    @Transactional
    public void run(String... args) {

        if (flightScheduleRepository.count() > 0)
            return;

        if (flightRepository.count() == 0)
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

        Flight TG25 = flightRepository.findByAirlineAndFlightNumber(TG,25);
        Flight TG26 = flightRepository.findByAirlineAndFlightNumber(TG,26);
        Flight KE4433 = flightRepository.findByAirlineAndFlightNumber(KE,4433);
        Flight KE4434 = flightRepository.findByAirlineAndFlightNumber(KE,4434);
        Flight UA1210 = flightRepository.findByAirlineAndFlightNumber(UA,1210);
        Flight UA1211 = flightRepository.findByAirlineAndFlightNumber(UA,1211);

        flightScheduleRepository.save(new FlightSchedule(
                TG25,
                Casting.Timestamp.from(2019, 12, 01, 10, 30),
                Casting.MinuteDuration.from( 16, 30),
                1200
                ));
        flightScheduleRepository.save(new FlightSchedule(
                TG26,
                Casting.Timestamp.from(2019, 12, 04, 22, 25),
                Casting.MinuteDuration.from( 15, 10),
                1250
        ));
        flightScheduleRepository.save(new FlightSchedule(
                KE4433,
                Casting.Timestamp.from(2019, 12, 10, 9, 40),
                Casting.MinuteDuration.from( 9, 40),
                900
        ));
        flightScheduleRepository.save(new FlightSchedule(
                KE4434,
                Casting.Timestamp.from(2019, 12, 12, 15, 15),
                Casting.MinuteDuration.from( 8, 45),
                950
        ));
        flightScheduleRepository.save(new FlightSchedule(
                UA1210,
                Casting.Timestamp.from(2019, 12, 15, 7, 10),
                Casting.MinuteDuration.from( 5, 40),
                500
        ));
        flightScheduleRepository.save(new FlightSchedule(
                UA1211,
                Casting.Timestamp.from(2019, 12, 16, 19, 15),
                Casting.MinuteDuration.from( 5, 20),
                520
        ));

    }
}
