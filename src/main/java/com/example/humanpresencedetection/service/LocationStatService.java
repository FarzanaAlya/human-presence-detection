package com.example.humanpresencedetection.service;

import com.example.humanpresencedetection.dto.LocationStatDTO;
import java.util.List;

public interface LocationStatService {
    List<LocationStatDTO> getAll();
}
