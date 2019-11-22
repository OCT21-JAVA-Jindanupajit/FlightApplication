package jbc.oct21.jindanupajit.flightapplication.initializer;

import jbc.oct21.jindanupajit.flightapplication.model.Airport;
import jbc.oct21.jindanupajit.flightapplication.model.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class AirportDataInitializer implements CommandLineRunner {

    @Autowired
    private AirportRepository airportRepository;

    public AirportDataInitializer() {
    }

    public void run(String... strings) {
        if (airportRepository.count() > 0)
            return;

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("./data/AirportDataInit.csv"));
            String line;

            while ((line = csvReader.readLine()) != null) {
                String[] token = line.split(", ");
                //System.out.printf("%s -> '%s'\n",token[2], token[4]);
                airportRepository.save(new Airport(token[0], token[1], token[2], token[3], null, token[5]));
            }

            csvReader.close();
        } catch (IOException e) {

        }

    }
}