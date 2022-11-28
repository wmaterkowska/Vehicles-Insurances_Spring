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
    public String getVehiclesInsurances(Model model, @RequestParam("id") Long userId) {
        model.addAttribute("listOfVehicles", this.service.getInsurancesForVehiclesOfUser( userId ));
        return "listOfVehicles";
    }

    // @RequestMapping(method = RequestMethod.GET)
    // @ResponseBody
    // public ModelAndView getInsurances(@RequestParam("id") long userId) {
    //     ModelAndView modelAndView = new ModelAndView("listOfVehicles");
    //     // modelAndView.setView("listOfVehicles");
    //     return modelAndView;
    // }



}
