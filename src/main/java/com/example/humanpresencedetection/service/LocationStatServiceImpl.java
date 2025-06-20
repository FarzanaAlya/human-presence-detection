package com.example.humanpresencedetection.service;

import com.example.humanpresencedetection.dto.LocationStatDTO;
import com.example.humanpresencedetection.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationStatServiceImpl implements LocationStatService {

    private final SensorDataRepository sensorDataRepository;

    public LocationStatServiceImpl(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @Override
    public List<LocationStatDTO> getAll() {
        return sensorDataRepository.getLocationStatistics(); // ✅ Correct method name
    }

}
