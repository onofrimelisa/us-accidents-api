package com.unlp.bbdd2.accidents.service;

import com.unlp.bbdd2.accidents.dto.*;
import com.unlp.bbdd2.accidents.exceptions.NotFoundException;
import com.unlp.bbdd2.accidents.model.Accident;
import com.unlp.bbdd2.accidents.model.TemperatureAggregation;
import com.unlp.bbdd2.accidents.model.WeatherConditionAggregation;
import com.unlp.bbdd2.accidents.repository.AccidentRepository;

import java.util.*;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AccidentService implements IAccidentService {

  private static final int PAGE_SIZE = 10;
  private static final double TEMPERATURE_THRESHOLD = 32.0;
  private static final String TEMPERATURE_SCALE = "FAHRENHEIT";
  private static final String MEASUREMENT_TYPE = "RELATIVE";

  @Autowired
  @Qualifier("getAccidentDTOMapper")
  private ModelMapper modelMapper;

  @Autowired
  private AccidentRepository accidentRepository;

  public Page<AccidentDTO> findAll() {
    Page<Accident> accidents = this.accidentRepository.findAll(Pageable.ofSize(PAGE_SIZE));
    return accidents.map(accident -> modelMapper.map(accident, AccidentDTO.class));
  }

  public AccidentDTO findById(String accidentId) throws NotFoundException {
    Optional<Accident> accident =
        Optional.ofNullable(this.accidentRepository.findByAccidentId(accidentId));
    return this.modelMapper.map(accident.orElseThrow(NotFoundException::new), AccidentDTO.class);
  }

  public Page<AccidentDTO> findByStartPointWithin(Polygon polygon) {
    Page<Accident> accidents = this.accidentRepository.findByStartPointWithin(
        polygon,
        Pageable.ofSize(PAGE_SIZE)
    );

    return accidents.map(accident -> modelMapper.map(accident, AccidentDTO.class));
  }

  public Page<AccidentDTO> findByStartPointWithin(Circle circle) {
    Page<Accident> accidents = this.accidentRepository.findByStartPointWithin(
        circle,
        Pageable.ofSize(PAGE_SIZE)
    );

    return accidents.map(accident -> modelMapper.map(accident, AccidentDTO.class));
  }

  public List<WeatherConditionDTO> getMostCommonWeatherConditions(Integer limit) {
    return this.accidentRepository.getMostCommonWeatherConditions(limit)
            .stream()
            .map(weatherConditionAggregation -> modelMapper.map(weatherConditionAggregation, WeatherConditionDTO.class))
            .collect(Collectors.toList());
  }

  @Override
  public TemperatureResponseDTO getTotalAccidentsByTemperature() {
    return TemperatureResponseDTO.builder()
            .scale(TEMPERATURE_SCALE)
            .data(this.accidentRepository.getTotalAccidentsByTemperature(TEMPERATURE_THRESHOLD)
                    .stream()
                    .map(temperatureAggregation -> modelMapper.map(temperatureAggregation, TemperatureDTO.class))
                    .collect(Collectors.toList())).build();
  }

  @Override
  public HumidityResponseDTO getTotalAccidentsByHumidity() {
    return HumidityResponseDTO.builder()
            .measurementType(MEASUREMENT_TYPE)
            .data(this.accidentRepository.getTotalAccidentsByHumidity()
                    .stream()
                    .map(humidityAggregation -> modelMapper.map(humidityAggregation, HumidityDTO.class))
                    .collect(Collectors.toList())).build();
  }
}
