package jbc.oct21.jindanupajit.flightapplication.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Flight {

    @Id
    @SequenceGenerator(name = "Flight", sequenceName = "FlightId", initialValue = 100000001, allocationSize = 1)
    @GeneratedValue(generator = "Flight")
    private long id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH}
    )
    private Airline airline = new Airline();

    private int flightNumber;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH}
    )
    private Airport from = new Airport();

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH}
    )
    private Airport destination = new Airport();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(airline.getIataCode()).append(" ").append(String.format("%04d",flightNumber));
        return sb.toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }
}
