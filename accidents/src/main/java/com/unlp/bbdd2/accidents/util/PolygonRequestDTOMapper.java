package com.unlp.bbdd2.accidents.util;

import com.unlp.bbdd2.accidents.dto.PolygonRequestDTO;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;

@Configuration
public class PolygonRequestDTOMapper {

  @Bean
  public ModelMapper getPolygonRequestDTOMapper() {
    ModelMapper modelMapper = new ModelMapper();

    // converters
    Converter<PolygonRequestDTO, Polygon> polygonConverter = c -> {
      PolygonRequestDTO polygonRequestDTO = c.getSource();

      List<Point> points = new ArrayList<>();
      polygonRequestDTO.getPoints()
                       .forEach(point -> points.add(new Point(point.getX(), point.getY())));

      return new Polygon(points);
    };

    // setup
    TypeMap<PolygonRequestDTO, Polygon>
        propertyMapper = modelMapper.createTypeMap(PolygonRequestDTO.class, Polygon.class);
    propertyMapper.setConverter(polygonConverter);

    modelMapper.getConfiguration().setSkipNullEnabled(true);

    return modelMapper;
  }

}
