package com.example.vehiclesInsurances.api;

import com.example.vehiclesInsurances.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/listOfVehicles")
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    public String getVehiclesInsurances(Model model, @RequestParam("id") long userId) {
        model.addAttribute("listOfVehicles", this.service.getInsurancesForVehiclesOfUser( userId ));
        return "listOfVehicles";
    }

    @RequestMapping(value = "/listOfVehicles", method = RequestMethod.GET)
    public ModelAndView getInsurances() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView("listOfVehicles");
        return modelAndView;
    }



}
