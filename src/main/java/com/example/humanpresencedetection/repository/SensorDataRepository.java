package com.example.humanpresencedetection.repository;

import com.example.humanpresencedetection.dto.LocationStatDTO;
import com.example.humanpresencedetection.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    List<SensorData> findTop20ByOrderByDetectionTimeDesc();

    @Query("SELECT new com.example.humanpresencedetection.dto.LocationStatDTO(" +
            "s.sensorLocation, COUNT(s), AVG(s.distance), AVG(s.energy)) " +
            "FROM SensorData s GROUP BY s.sensorLocation")
    List<LocationStatDTO> getLocationStatistics();

    @Query("SELECT FUNCTION('FORMATDATETIME', s.detectionTime, 'yyyy-MM-dd'), COUNT(s), AVG(s.distance) " +
            "FROM SensorData s " +
            "WHERE s.detectionTime >= :startDate " +
            "GROUP BY FUNCTION('FORMATDATETIME', s.detectionTime, 'yyyy-MM-dd') " +
            "ORDER BY FUNCTION('FORMATDATETIME', s.detectionTime, 'yyyy-MM-dd')")
    List<Object[]> findDailyAveragesLast7Days(@Param("startDate") LocalDateTime startDate);
}

