package jbc.oct21.jindanupajit.flightapplication.initializer;

import jbc.oct21.jindanupajit.flightapplication.model.Airline;
import jbc.oct21.jindanupajit.flightapplication.model.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class AirlineDataInitializer implements CommandLineRunner {

    @Autowired
    private AirlineRepository airlineRepository;

    public AirlineDataInitializer() {
    }

    public void run(String... strings) {
        if (airlineRepository.count() > 0)
            return;

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("./data/AirlineDataInit.csv"));
            String line;

            while ((line = csvReader.readLine()) != null) {
                String[] token = line.split("\",\"");
                airlineRepository.save(new Airline(
                        token[0].replace("\"","").trim(),
                        null,
                        token[1].replace("\"","").trim()));
            }

            csvReader.close();
        } catch (IOException e) {

        }

    }
}