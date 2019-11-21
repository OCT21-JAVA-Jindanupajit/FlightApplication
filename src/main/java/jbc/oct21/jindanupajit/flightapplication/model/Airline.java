package jbc.oct21.jindanupajit.flightapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Airline {
    @Id
    @SequenceGenerator(name = "Airline", sequenceName = "AirlineId", initialValue = 300000001, allocationSize = 1)
    @GeneratedValue(generator = "Airline")
    private long id;

    private String iataCode;
    private String icaoCode;
    private String name;

    @Override
    public String toString() {

        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
