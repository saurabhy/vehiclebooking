package com.practice.vehiclebooking.entity;

import lombok.Data;

import java.util.*;

@Data
public class Branch {

    private List<VehicleType> availableTypes;

    private Map<String,List<Vehicle>> inventoryList;

    private Set<String> vehicleHash;

    private String branchId;

    public Branch(String bid){
        branchId = bid;
        availableTypes = new ArrayList<>();
        inventoryList = new HashMap<>();
        vehicleHash = new HashSet<>();
    }
}
