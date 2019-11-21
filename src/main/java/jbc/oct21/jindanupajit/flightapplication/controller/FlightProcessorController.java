package jbc.oct21.jindanupajit.flightapplication.controller;

import jbc.oct21.jindanupajit.flightapplication.model.FlightSchedule;
import jbc.oct21.jindanupajit.flightapplication.model.repository.FlightScheduleRepository;
import jbc.oct21.jindanupajit.flightapplication.util.Casting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flight/process")
public class FlightProcessorController {

    @Autowired
    FlightScheduleRepository flightScheduleRepository;

    @PostMapping(value={"/add", "/edit"})
    public String save(@ModelAttribute FlightSchedule flightSchedule,
                       @RequestParam String departureString) {

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
