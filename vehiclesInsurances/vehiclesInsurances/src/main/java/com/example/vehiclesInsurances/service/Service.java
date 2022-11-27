package com.example.vehiclesInsurances.service;

import com.example.vehiclesInsurances.data.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    private UserRepository userRepository;
    private VehicleRepository vehicleRepository;
    private InsuranceRepository insuranceRepository;

    public List<Vehicle> getAllVehiclesForUserWithId(Long userId) {
        return this.vehicleRepository.findByUserId(userId);
    }

    public List<Insurance> getAllInsurancesForVehicle(Long vehicleId) {
        return this.insuranceRepository.findAllByVehicleId(vehicleId);
    }

    public Map<Vehicle,List<Insurance>> getInsurancesForVehiclesOfUser(Long userId){
        Map<Vehicle,List <Insurance> > vehicleInsurancesMap = new HashMap<>();

        List<Vehicle> vehiclesOfUser =  getAllVehiclesForUserWithId(userId);

        for (Vehicle vehicle : vehiclesOfUser) {
            List<Insurance> insurancesForVehicle = getAllInsurancesForVehicle(vehicle.getId());
            vehicleInsurancesMap.put(vehicle, insurancesForVehicle);
        }

        return vehicleInsurancesMap;

    }


}
