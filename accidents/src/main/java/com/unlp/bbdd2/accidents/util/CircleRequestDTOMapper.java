package com.unlp.bbdd2.accidents.util;

import com.unlp.bbdd2.accidents.dto.CircleRequestDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;

@Configuration
public class CircleRequestDTOMapper {

  @Bean
  public ModelMapper getCircleRequestDTOMapper() {
    ModelMapper modelMapper = new ModelMapper();

    // converters
    Converter<CircleRequestDTO, Circle> circleConverter = c -> {
      CircleRequestDTO circleRequestDTO = c.getSource();

      return new Circle(
          new Point(
              circleRequestDTO.getPoint().getX(),
              circleRequestDTO.getPoint().getY()
          ),
          circleRequestDTO.getRadius()
      );
    };

    // setup
    TypeMap<CircleRequestDTO, Circle>
        propertyMapper = modelMapper.createTypeMap(CircleRequestDTO.class, Circle.class);
    propertyMapper.setConverter(circleConverter);

    modelMapper.getConfiguration().setSkipNullEnabled(true);

    return modelMapper;
  }

}
