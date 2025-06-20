package com.example.humanpresencedetection.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "sensor_data")
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "detection_time")
    private LocalDateTime detectionTime;

    private Double distance;
    private Integer energy;

    @Column(name = "is_moving")
    private Boolean isMoving;

    @Column(name = "sensitivity_level")
    private Integer sensitivityLevel;

    @Column(name = "sensor_location")
    private String sensorLocation;

}