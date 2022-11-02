package com.unlp.bbdd2.accidents.service;

import com.unlp.bbdd2.accidents.dto.*;
import com.unlp.bbdd2.accidents.exceptions.NotFoundException;
import com.unlp.bbdd2.accidents.model.*;
import com.unlp.bbdd2.accidents.repository.AccidentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

@ExtendWith(SpringExtension.class)
class AccidentServiceTest {

    @MockBean
    private AccidentRepository accidentRepository;
    @MockBean
    private ModelMapper modelMapper;

    private AccidentService accidentService;


    @BeforeEach
    void setUp() {
        accidentService = new AccidentService(modelMapper, accidentRepository);
    }

    @Test
    void findAllSuccessful() {
        // Arrange
        Accident accident = AccidentFixture.withDefaults();
        AccidentDTO accidentDTO = AccidentDTOFixture.withDefaults();
        List<Accident> accidentList = newArrayList(accident);
        Page<Accident> accidents = new PageImpl<>(accidentList);

        Mockito.when(accidentRepository.findAll((Pageable) Mockito.any())).thenReturn(accidents);

        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(accidentDTO);

        // Act
        Page<AccidentDTO> result = this.accidentService.findAll();

        // Assert
        Assertions.assertNotNull(result.get());
        Mockito.verify(accidentRepository, Mockito.times(1)).findAll((Pageable) Mockito.any());
        Mockito.verify(modelMapper, Mockito.times(1)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void findAllThrowsException() {
        // Arrange
        RuntimeException e = new RuntimeException("Error from test");
        Mockito.when(accidentRepository.findAll((Pageable) Mockito.any())).thenThrow(e);

        // Act & Assert
        Assertions.assertThrows(e.getClass(), () -> this.accidentService.findAll());
        Mockito.verify(accidentRepository, Mockito.times(1)).findAll((Pageable) Mockito.any());
        Mockito.verify(modelMapper, Mockito.times(0)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void findByIdSuccessful() throws NotFoundException {
        // Arrange
        Accident accident = AccidentFixture.withDefaults();
        AccidentDTO accidentDTO = AccidentDTOFixture.withDefaults();
        Mockito.when(accidentRepository.findByAccidentId(Mockito.anyString())).thenReturn(accident);
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(accidentDTO);

        // Act
        AccidentDTO result = this.accidentService.findById("1234");

        // Assert
        Assertions.assertNotNull(result);
        Mockito.verify(accidentRepository, Mockito.times(1)).findByAccidentId(Mockito.anyString());
        Mockito.verify(modelMapper, Mockito.times(1)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void findByIdThrowsException() {
        // Arrange
        Mockito.when(accidentRepository.findByAccidentId(Mockito.anyString())).thenReturn(null);

        // Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> this.accidentService.findById("1234"));
        Mockito.verify(accidentRepository, Mockito.times(1)).findByAccidentId(Mockito.anyString());
        Mockito.verify(modelMapper, Mockito.times(0)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void findByStartPointWithinPolygonThrowsException() {
        // Arrange
        List<Point> points = new ArrayList<>();
        Polygon polygon = new Polygon(points);
        RuntimeException e = new RuntimeException("Error from test");

        Mockito.when(accidentRepository.findByStartPointWithin(Mockito.any(), Mockito.any())).thenThrow(e);

        // Act & Assert
        Assertions.assertThrows(e.getClass(), () -> this.accidentService.findByStartPointWithin(polygon));
        Mockito.verify(accidentRepository, Mockito.times(1)).findByStartPointWithin(Mockito.any(), Mockito.any());
        Mockito.verify(modelMapper, Mockito.times(0)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void findByStartPointWithinPolygonSuccessful() {
        // Arrange
        List<Point> points = new ArrayList<>();
        Polygon polygon = new Polygon(points);
        AccidentDTO accidentDTO = AccidentDTOFixture.withDefaults();
        Accident accident = AccidentFixture.withDefaults();
        List<Accident> accidentList = newArrayList(accident);
        Page<Accident> accidents = new PageImpl<>(accidentList);

        Mockito.when(accidentRepository.findByStartPointWithin(Mockito.any(), Mockito.any())).thenReturn(accidents);

        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(accidentDTO);

        // Act
        Page<AccidentDTO> result = this.accidentService.findByStartPointWithin(polygon);

        // Assert
        Assertions.assertNotNull(result.get());
        Mockito.verify(accidentRepository, Mockito.times(1)).findByStartPointWithin(Mockito.any(), Mockito.any());
        Mockito.verify(modelMapper, Mockito.times(1)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void findByStartPointWithinCircleThrowsException() {
        // Arrange
        Circle circle = new Circle(new Point(0.1, 0.1), 0.1);
        RuntimeException e = new RuntimeException("Error from test");

        Mockito.when(accidentRepository.findByStartPointWithin(Mockito.any(), Mockito.any())).thenThrow(e);

        // Act & Assert
        Assertions.assertThrows(e.getClass(), () -> this.accidentService.findByStartPointWithin(circle));
        Mockito.verify(accidentRepository, Mockito.times(1)).findByStartPointWithin(Mockito.any(), Mockito.any());
        Mockito.verify(modelMapper, Mockito.times(0)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void findByStartPointWithinCircleSuccessful() {
        // Arrange
        Circle circle = new Circle(new Point(0.1, 0.1), 0.1);
        AccidentDTO accidentDTO = AccidentDTOFixture.withDefaults();
        Accident accident = AccidentFixture.withDefaults();
        List<Accident> accidentList = newArrayList(accident);
        Page<Accident> accidents = new PageImpl<>(accidentList);

        Mockito.when(accidentRepository.findByStartPointWithin(Mockito.any(), Mockito.any())).thenReturn(accidents);

        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(accidentDTO);

        // Act
        Page<AccidentDTO> result = this.accidentService.findByStartPointWithin(circle);

        // Assert
        Assertions.assertNotNull(result.get());
        Mockito.verify(accidentRepository, Mockito.times(1)).findByStartPointWithin(Mockito.any(), Mockito.any());
        Mockito.verify(modelMapper, Mockito.times(1)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void getMostCommonWeatherConditionsSuccessful() {
        // Arrange
        List<WeatherConditionAggregation> weatherConditionAggregationList = List.of(
                WeatherConditionAggregation.builder().id("Clear").totalAccidents(BigInteger.valueOf(100)).build(),
                WeatherConditionAggregation.builder().id("Overcast").totalAccidents(BigInteger.valueOf(80)).build()
        );
        List<WeatherConditionDTO> weatherConditionDTOList = List.of(
                WeatherConditionDTO.builder().weatherCondition("Clear").totalAccidents(BigInteger.valueOf(100)).build(),
                WeatherConditionDTO.builder().weatherCondition("Overcast").totalAccidents(BigInteger.valueOf(80)).build()
        );

        Mockito.when(accidentRepository.getMostCommonWeatherConditions(2)).thenReturn(weatherConditionAggregationList);
        Mockito.when(modelMapper.map(weatherConditionAggregationList.get(0), WeatherConditionDTO.class))
                .thenReturn(weatherConditionDTOList.get(0));
        Mockito.when(modelMapper.map(weatherConditionAggregationList.get(1), WeatherConditionDTO.class))
                .thenReturn(weatherConditionDTOList.get(1));

        // Act
        List<WeatherConditionDTO> result = this.accidentService.getMostCommonWeatherConditions(2);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(weatherConditionDTOList, result);
        Mockito.verify(accidentRepository, Mockito.times(1)).getMostCommonWeatherConditions(2);
        Mockito.verify(modelMapper, Mockito.times(2)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void getTotalAccidentsByTemperatureSuccessful() {
        // Arrange
        List<TemperatureAggregation> temperatureAggregationList = List.of(
                TemperatureAggregation.builder().criteria("BELOW").threshold(32.0).totalAccidents(BigInteger.valueOf(100)).build(),
                TemperatureAggregation.builder().criteria("ABOVE").threshold(32.0).totalAccidents(BigInteger.valueOf(80)).build()
        );

        TemperatureResponseDTO temperatureResponseDTO = TemperatureResponseDTO.builder()
                .scale("FAHRENHEIT")
                .data(List.of(
                        TemperatureDTO.builder().criteria("BELOW").threshold(32.0).totalAccidents(BigInteger.valueOf(100)).build(),
                        TemperatureDTO.builder().criteria("ABOVE").threshold(32.0).totalAccidents(BigInteger.valueOf(80)).build()))
                .build();

        Mockito.when(accidentRepository.getTotalAccidentsByTemperature(32.0)).thenReturn(temperatureAggregationList);
        Mockito.when(modelMapper.map(temperatureAggregationList.get(0), TemperatureDTO.class))
                .thenReturn(temperatureResponseDTO.getData().get(0));
        Mockito.when(modelMapper.map(temperatureAggregationList.get(1), TemperatureDTO.class))
                .thenReturn(temperatureResponseDTO.getData().get(1));

        // Act
        TemperatureResponseDTO result = this.accidentService.getTotalAccidentsByTemperature();

        // Assert
        Assertions.assertEquals(temperatureResponseDTO, result);
        Mockito.verify(accidentRepository, Mockito.times(1)).getTotalAccidentsByTemperature(32.0);
        Mockito.verify(modelMapper, Mockito.times(2)).map(Mockito.any(), Mockito.any());
    }

    @Test
    void getTotalAccidentsByHumiditySuccessful() {
        // Arrange
        List<HumidityAggregation> humidityAggregationList = List.of(
                HumidityAggregation.builder()
                        .totalAccidents(BigInteger.valueOf(100))
                        .range(HumidityAggregation.RangeAggregation.builder().from(0).to(50).build()).build(),
                HumidityAggregation.builder()
                        .totalAccidents(BigInteger.valueOf(200))
                        .range(HumidityAggregation.RangeAggregation.builder().from(50).to(100).build()).build()
        );

        HumidityResponseDTO humidityResponseDTO = HumidityResponseDTO.builder()
                .measurementType("RELATIVE")
                .data(List.of(
                        HumidityDTO.builder()
                                .totalAccidents(BigInteger.valueOf(100))
                                .range(HumidityDTO.RangeDTO.builder().from(0).to(50).build()).build(),
                        HumidityDTO.builder()
                                .totalAccidents(BigInteger.valueOf(200))
                                .range(HumidityDTO.RangeDTO.builder().from(50).to(100).build()).build()
                )).build();

        Mockito.when(accidentRepository.getTotalAccidentsByHumidity()).thenReturn(humidityAggregationList);
        Mockito.when(modelMapper.map(humidityAggregationList.get(0), HumidityDTO.class))
                .thenReturn(humidityResponseDTO.getData().get(0));
        Mockito.when(modelMapper.map(humidityAggregationList.get(1), HumidityDTO.class))
                .thenReturn(humidityResponseDTO.getData().get(1));

        // Act
        HumidityResponseDTO result = this.accidentService.getTotalAccidentsByHumidity();

        // Assert
        Assertions.assertEquals(humidityResponseDTO, result);
        Mockito.verify(accidentRepository, Mockito.times(1)).getTotalAccidentsByHumidity();
        Mockito.verify(modelMapper, Mockito.times(2)).map(Mockito.any(), Mockito.any());
    }

}
