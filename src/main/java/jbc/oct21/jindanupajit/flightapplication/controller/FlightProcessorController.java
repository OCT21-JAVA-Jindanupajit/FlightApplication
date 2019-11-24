package jbc.oct21.jindanupajit.flightapplication.controller;

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
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flight/process")
public class FlightProcessorController {

    @Autowired
    FlightScheduleRepository flightScheduleRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    AirlineRepository airlineRepository;



    @PostMapping(value={"/add", "/edit"})
    @Transactional
    public String save(@ModelAttribute FlightSchedule flightSchedule,
                       @RequestParam String airlineString,
                       @RequestParam String flightNumberString,
                       @RequestParam String departureDateString,
                       @RequestParam String departureTimeString,
                       @RequestParam String fromString,
                       @RequestParam String toString,
                       @RequestParam String priceString
                       ) {

        // These airline and airport must already existing in database
        Airport from = airportRepository.findByIataCode(fromString.toUpperCase().trim());
        if (from == null) return "/";
        System.out.println("From "+from.getName());

        Airport to = airportRepository.findByIataCode(toString.toUpperCase().trim());
        if (to == null) return "/";
        System.out.println("To :"+to.getName());

        Airline airline = airlineRepository.findByIataCode(airlineString.toUpperCase().trim());
        if (airline == null) return "/";
        System.out.println("Airline "+airline.getName());
        // **

        Flight flight =flightRepository.findByAirlineAndFlightNumber(airline, Casting.Integer.from(flightNumberString));


        if (flight == null) {  // new flight info, leave the old one alone
            flight = new Flight(airline, Casting.Integer.from(flightNumberString), from, to);
            flightRepository.save(flight);
        }
        else {
            flight.setFrom(from);
            flight.setDestination(to);
        }
        System.out.printf("Flight: %s %d\n", flight.getAirline().getIataCode(), flight.getFlightNumber());

        flightSchedule.setFlight(flight);
        flightSchedule.setDeparture(Casting.Timestamp.from(departureDateString, departureTimeString));
        flightSchedule.setPrice(Casting.Double.from(priceString));


        flightScheduleRepository.save(flightSchedule);

        return "redirect:/flight/view/"+flightSchedule.getId();
    }

    @GetMapping("/delete/{idString}")
    public String delete(@PathVariable String idString) {
        long id = Casting.Long.from(idString);

            if (flightScheduleRepository.existsById(id))
                flightScheduleRepository.deleteById(id);

        return "redirect:/flight/view/all";
    }


}
