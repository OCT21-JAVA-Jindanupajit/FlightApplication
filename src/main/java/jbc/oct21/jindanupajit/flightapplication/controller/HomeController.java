package jbc.oct21.jindanupajit.flightapplication.controller;

import jbc.oct21.jindanupajit.flightapplication.model.repository.FlightScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    FlightScheduleRepository flightScheduleRepository;

    @ModelAttribute
    public void global(Model model) {
       // model.addAttribute("authenticatedUser", UserDetailsServiceImpl.getAuthentication());
        model.addAttribute("WebSecurityEnabled", false);
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/flight/view/all";
    }

    @GetMapping("/search")
    public String search(@RequestParam("q") String query) {

        return "flight_view";
    }
}
