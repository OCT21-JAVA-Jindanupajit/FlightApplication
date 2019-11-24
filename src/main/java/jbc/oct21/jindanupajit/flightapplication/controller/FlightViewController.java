package jbc.oct21.jindanupajit.flightapplication.controller;

import jbc.oct21.jindanupajit.flightapplication.model.FlightSchedule;
import jbc.oct21.jindanupajit.flightapplication.model.repository.FlightScheduleRepository;
import jbc.oct21.jindanupajit.flightapplication.util.Casting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flight/view")
public class FlightViewController {

    @Autowired
    FlightScheduleRepository flightScheduleRepository;

    @ModelAttribute
    public void global(Model model) {

        model.addAttribute("WebSecurityEnabled", false);
    }

    @GetMapping("/all")
    public String viewAll(Model model) {
        model.addAttribute("id",0);
        model.addAttribute("mode","list");
        model.addAttribute("flightScheduleCollection", flightScheduleRepository.findAll());
        return "flight_view";
    }

    @GetMapping("/{idString}")
    public String viewById(Model model, @PathVariable String idString) {
        long id = Casting.Long.from(idString);
        model.addAttribute("id",id);
        model.addAttribute("mode","view");
        model.addAttribute("flightSchedule", flightScheduleRepository.findById(id).orElse(new FlightSchedule()));
        return "flight_view";
    }


    @GetMapping("/{idString}/editable")
    public String editById(Model model, @PathVariable String idString) {
        long id = Casting.Long.from(idString);
        model.addAttribute("id",id);
        model.addAttribute("mode","edit");
        model.addAttribute("flightSchedule", flightScheduleRepository.findById(id).orElse(new FlightSchedule()));
        return "flight_view";
    }

}


