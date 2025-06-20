package com.example.humanpresencedetection.controller;

import org.springframework.ui.Model; // ✅ CORRECT
import com.example.humanpresencedetection.dto.LocationStatDTO;
import com.example.humanpresencedetection.repository.SensorDataRepository;
import com.example.humanpresencedetection.service.LocationStatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private final SensorDataRepository sensorDataRepo;
    private final LocationStatService locationStatService;

    public DashboardController(SensorDataRepository sensorDataRepo,
                               LocationStatService locationStatService) {
        this.sensorDataRepo = sensorDataRepo;
        this.locationStatService = locationStatService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<LocationStatDTO> stats = locationStatService.getAll();

        long totalCount = stats.stream().mapToLong(stat -> stat.getCount()).sum();
        double avgDistance = stats.stream().mapToDouble(stat -> stat.getAvgDistance()).average().orElse(0.0);
        double avgEnergy = stats.stream().mapToDouble(stat -> stat.getAvgEnergy()).average().orElse(0.0);

        model.addAttribute("locationStats", stats);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("avgDistance", String.format("%.2f", avgDistance));
        model.addAttribute("avgEnergy", String.format("%.2f", avgEnergy));

        return "dashboard";
    }
}
