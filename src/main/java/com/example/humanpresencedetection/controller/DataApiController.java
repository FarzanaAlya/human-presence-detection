package com.example.humanpresencedetection.controller;

import com.example.humanpresencedetection.repository.SensorDataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DataApiController {

    private final SensorDataRepository sensorDataRepo;

    public DataApiController(SensorDataRepository sensorDataRepo) {
        this.sensorDataRepo = sensorDataRepo;
    }

    @GetMapping("/chart-data")
    public Map<String, Object> getChartData() {
        LocalDateTime sevenDaysAgo = LocalDate.now().minusDays(7).atStartOfDay();
        return Map.of(
                "dailyAverages", sensorDataRepo.findDailyAveragesLast7Days(sevenDaysAgo),
                "locationDistribution", sensorDataRepo.getLocationStatistics()
        );
    }

}