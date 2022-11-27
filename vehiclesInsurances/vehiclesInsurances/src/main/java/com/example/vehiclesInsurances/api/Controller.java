package com.example.vehiclesInsurances.api;

import com.example.vehiclesInsurances.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getVehiclesInsurances(Model model, @PathVariable("id") long userId) {
        model.addAttribute("vehicleInsurances", this.service.getInsurancesForVehiclesOfUser( userId ));
        return "vehicleInsurances";
    }


}
