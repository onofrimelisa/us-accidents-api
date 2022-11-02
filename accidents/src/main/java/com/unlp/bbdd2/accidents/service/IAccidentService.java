package com.unlp.bbdd2.accidents.service;

import com.unlp.bbdd2.accidents.dto.*;
import com.unlp.bbdd2.accidents.exceptions.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Polygon;

public interface IAccidentService {

  Page<AccidentDTO> findAll();

  AccidentDTO findById(String accidentId) throws NotFoundException;

  Page<AccidentDTO> findByStartPointWithin(Polygon polygon);

  Page<AccidentDTO> findByStartPointWithin(Circle circle);

  List<WeatherConditionDTO> getMostCommonWeatherConditions(Integer limit);

  TemperatureResponseDTO getTotalAccidentsByTemperature();

  HumidityResponseDTO getTotalAccidentsByHumidity();
}
