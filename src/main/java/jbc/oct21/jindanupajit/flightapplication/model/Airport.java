package jbc.oct21.jindanupajit.flightapplication.model;

import jbc.oct21.jindanupajit.flightapplication.model.converter.ZoneIdConverter;
import jbc.oct21.jindanupajit.flightapplication.model.repository.CloudinaryImage;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Entity
public class Airport {

    @Id
    @SequenceGenerator(name = "Airport", sequenceName = "AirportId", initialValue = 400000001, allocationSize = 1)
    @GeneratedValue(generator = "Airport")
    private long id;

    private String iataCode;

    private String icaoCode;

    private String name;

    private String location;

    @OneToOne(
            cascade = CascadeType.PERSIST,
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private CloudinaryImage image;

    @Convert(converter = ZoneIdConverter.class)
    private ZoneId zoneId = ZoneId.of(ZoneOffset.UTC.getId());

    public Airport() {}

    public Airport(String iataCode, String icaoCode, String name, String location, CloudinaryImage image, String zoneIdString) {
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.name = name;
        this.location = location;
        this.image = image;
        try {
            this.zoneId = ZoneId.of(zoneIdString);
        } catch (Exception e) {
            this.zoneId = ZoneId.of(ZoneOffset.UTC.getId());
        }
    }

    @Override
    public String toString() {
       return iataCode;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
}
