package jbc.oct21.jindanupajit.flightapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Fair {
    @Id
    @SequenceGenerator(name = "Fair", sequenceName = "FairId", initialValue = 500000001, allocationSize = 1)
    @GeneratedValue(generator = "Fair")
    private long id;

    private String code;

    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return String.format("%.2f",price);
    }
}
