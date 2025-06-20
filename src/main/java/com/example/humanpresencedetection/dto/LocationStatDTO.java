package com.example.humanpresencedetection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationStatDTO {
    private String location;
    private long count;
    private double avgDistance;
    private double avgEnergy;
}


