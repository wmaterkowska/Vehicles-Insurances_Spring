package com.example.vehiclesInsurances.service;

import com.example.vehiclesInsurances.data.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private InsuranceRepository insuranceRepository;

    private List<Vehicle> getAllVehiclesOfUserWithId(Long userId) {

        User user = this.userRepository.findById(userId).stream().findFirst().orElse(null);
        String login = null;
        if (user != null) {
            login = user.getLogin();
        }

        return this.vehicleRepository.findByLogin(login);
    }

    private List<Insurance> getAllInsurancesForVehicle(Long vehicleId) {
        return this.insuranceRepository.findAllByVehicleId(vehicleId);
    }

    public Map<Vehicle,List<Insurance>> getInsurancesForVehiclesOfUser(Long userId){
        Map<Vehicle,List <Insurance> > vehicleInsurancesMap = new HashMap<>();

        List<Vehicle> vehiclesOfUser =  getAllVehiclesOfUserWithId(userId);

        for (Vehicle vehicle : vehiclesOfUser) {
            List<Insurance> insurancesForVehicle = getAllInsurancesForVehicle(vehicle.getId());
            vehicleInsurancesMap.put(vehicle, insurancesForVehicle);
        }

        return vehicleInsurancesMap;

    }


}
