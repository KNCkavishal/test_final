package com.ecotrip.ecotrip_backend.service;

import com.ecotrip.ecotrip_backend.model.Vehicle;
import java.util.List;

public interface VehicleService {
    Vehicle registerVehicle(Vehicle vehicle) throws Exception;
    List<Vehicle> getVehiclesByType(String type);
    List<Vehicle> getAllVehicles();
}
