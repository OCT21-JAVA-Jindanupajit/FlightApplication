package jbc.oct21.jindanupajit.flightapplication.model;

import jbc.oct21.jindanupajit.flightapplication.util.Casting;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
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

    private Timestamp departure = Casting.Timestamp.now();

    private int duration;

    @OneToMany (
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Fair> fairCollection = new ArrayList<>();

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

    public Timestamp getDeparture() {
        return departure;
    }

    public String getDepartureString() {
        return String.format("%s %s",getDepartureDateString(), getDepartureTimeString());
    }
    public String getDepartureDateString() {
        return departure.toLocalDateTime().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public String getDepartureTimeString() {
        return departure.toLocalDateTime().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
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

    public List<Fair> getFairCollection() {
        return fairCollection;
    }

    public void setFairCollection(List<Fair> fairCollection) {
        this.fairCollection = fairCollection;
    }
}
