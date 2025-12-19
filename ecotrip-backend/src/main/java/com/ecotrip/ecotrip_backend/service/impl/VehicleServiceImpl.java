package com.ecotrip.ecotrip_backend.service.impl;

import com.ecotrip.ecotrip_backend.model.Vehicle;
import com.ecotrip.ecotrip_backend.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl {

    private final VehicleRepository repo;

    public VehicleServiceImpl(VehicleRepository repo) {
        this.repo = repo;
    }

    public Vehicle registerVehicle(Vehicle vehicle) throws Exception {
        if (repo.existsByVehicleNumber(vehicle.getVehicleNumber())) {
            throw new Exception("Vehicle already exists");
        }
        return repo.save(vehicle);
    }
}
