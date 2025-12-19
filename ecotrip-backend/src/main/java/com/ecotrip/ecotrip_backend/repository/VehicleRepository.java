package com.ecotrip.ecotrip_backend.repository;

import com.ecotrip.ecotrip_backend.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    boolean existsByVehicleNumber(String vehicleNumber);
}
