package jbc.oct21.jindanupajit.flightapplication.model;

import jbc.oct21.jindanupajit.flightapplication.util.Casting;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FlightSchedule {

    @Id
    @SequenceGenerator(name = "FlightSchedule", sequenceName = "FlightScheduleId", initialValue = 200000001, allocationSize = 1)
    @GeneratedValue(generator = "FlightSchedule")
    private long id;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST,
            orphanRemoval = false
    )
    private Flight flight = new Flight();

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = false
    )
    private List<Flight> returnFlightCollection = new ArrayList<>();


    private Timestamp departure = Casting.Timestamp.nowNoSec();

    private int duration;

    @OneToMany (
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Fare> fareCollection = new ArrayList<>();

    public FlightSchedule() {
    }

    public FlightSchedule(Flight flight, Timestamp departure, int duration) {
        this.flight = flight;
        this.departure = departure;
        this.duration = duration;
    }

    public FlightSchedule(Flight flight, Timestamp departure, int duration, double price) {
        this.flight = flight;
        this.departure = departure;
        this.duration = duration;
        setPrice(price);
    }

    public FlightSchedule(Flight flight, List<Flight> returnFlightCollection, Timestamp departure, int duration, List<Fare> fairCollection) {
        this.flight = flight;
        this.returnFlightCollection = returnFlightCollection;
        this.departure = departure;
        this.duration = duration;
        this.fareCollection = fairCollection;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Flight> getReturnFlightCollection() {
        return returnFlightCollection;
    }

    public void setReturnFlightCollection(List<Flight> returnFlightCollection) {
        this.returnFlightCollection = returnFlightCollection;
    }

    public Timestamp getDeparture() { // System Zone
        return departure;
    }

    public Timestamp getArrival() { // System Zone
        return Timestamp.valueOf(departure.toLocalDateTime().plusMinutes(duration));
    }

    public Timestamp getDepartureLocal() { // Local Time at Depart Airport
        return Casting.Timestamp.to(getFlight().getFrom().getZoneId(), getDeparture());
    }

    public Timestamp getArrivalLocal() { // Local Time at Arrival Airport
        return Casting.Timestamp.to(getFlight().getDestination().getZoneId(), getArrival());
    }

    public void setDeparture(Timestamp departure) {
        this.departure = departure;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Fare> getFareCollection() {
        return fareCollection;
    }

    public void setFareCollection(List<Fare> fareCollection) {
        this.fareCollection = fareCollection;
    }

    public double getPrice() {
        if (fareCollection == null)
                return 0;

        if (fareCollection.size() == 0)
                return 0;

        return fareCollection.get(0).getPrice();
    }

    public void setPrice(double price) {
        if (fareCollection == null)
            fareCollection = new ArrayList<>();

        if (fareCollection.size() == 0)
            fareCollection.add(new Fare());

        fareCollection.get(0).setPrice(price);
        fareCollection.get(0).setCode("E");
    }
}
