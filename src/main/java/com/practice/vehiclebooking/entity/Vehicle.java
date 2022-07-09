package com.practice.vehiclebooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private VehicleType vehicleType;

    private Double pricePerHr;

    private String vehicleId;

    private Long slots;
}
