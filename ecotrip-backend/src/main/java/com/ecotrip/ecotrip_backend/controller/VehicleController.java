package com.ecotrip.ecotrip_backend.controller;

import com.ecotrip.ecotrip_backend.model.Vehicle;
import com.ecotrip.ecotrip_backend.service.impl.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
@CrossOrigin(origins = "http://localhost:3000") // allows frontend
public class VehicleController {

    private final VehicleServiceImpl service;

    public VehicleController(VehicleServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody Vehicle vehicle) {
        try {
            Vehicle saved = service.registerVehicle(vehicle);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
