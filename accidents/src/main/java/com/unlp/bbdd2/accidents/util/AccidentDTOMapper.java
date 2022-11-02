package com.unlp.bbdd2.accidents.util;

import com.mongodb.client.model.geojson.Point;
import com.unlp.bbdd2.accidents.dto.AccidentDTO;
import com.unlp.bbdd2.accidents.dto.PointDTO;
import com.unlp.bbdd2.accidents.dto.WeatherConditionDTO;
import com.unlp.bbdd2.accidents.model.Accident;
import java.util.Optional;

import com.unlp.bbdd2.accidents.model.WeatherConditionAggregation;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccidentDTOMapper {

  @Bean
  public ModelMapper getAccidentDTOMapper() {
    ModelMapper modelMapper = new ModelMapper();

    // converters
    Converter<Point, PointDTO> pointDTOConverter = c -> {
      Optional<Point> source = Optional.ofNullable(c.getSource());

      return source
          .map(point -> new PointDTO(point.getCoordinates().getValues().get(0),
                                     point.getCoordinates().getValues().get(1)))
          .orElse(null);
    };

    // setup
    TypeMap<Accident, AccidentDTO> propertyMapper =
        modelMapper.createTypeMap(Accident.class, AccidentDTO.class);
    propertyMapper.addMappings(
        mapper -> {
          mapper.using(pointDTOConverter).map(Accident::getStartPoint, AccidentDTO::setStartPoint);
          mapper.using(pointDTOConverter).map(Accident::getStopPoint, AccidentDTO::setStopPoint);
        }
    );

    TypeMap<WeatherConditionAggregation, WeatherConditionDTO> weatherConditionPropertyMapper = modelMapper
            .createTypeMap(WeatherConditionAggregation.class, WeatherConditionDTO.class);
    weatherConditionPropertyMapper.addMappings(
            mapper -> mapper.map(WeatherConditionAggregation::getId, WeatherConditionDTO::setWeatherCondition)
    );

    modelMapper.getConfiguration().setSkipNullEnabled(true);

    return modelMapper;
  }
}
