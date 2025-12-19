package com.ecotrip.ecotrip_backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vehicles")
public class Vehicle {

    @Id
    private String id;

    @NotBlank
    private String ownerName;

    @NotBlank
    private String brand;

    @NotBlank
    private String vehicleNumber;

    @NotBlank
    private String type; // Private / Public / Maintenance

    @NotNull
    private Integer modelYear;

    @NotNull
    private Integer registrationYear;

    @NotBlank
    private String province;

    @NotBlank
    private String district;
}
