package com.unlp.bbdd2.accidents.service;

import com.unlp.bbdd2.accidents.dto.AccidentDTO;
import com.unlp.bbdd2.accidents.dto.AccidentDTOFixture;
import com.unlp.bbdd2.accidents.model.Accident;
import com.unlp.bbdd2.accidents.model.AccidentFixture;
import com.unlp.bbdd2.accidents.repository.AccidentRepository;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.data.geo.Shape;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.unlp.bbdd2.accidents.exceptions.NotFoundException;

import static org.assertj.core.util.Lists.newArrayList;

@ExtendWith(SpringExtension.class)
class AccidentServiceTest {

  @MockBean private AccidentRepository accidentRepository;
  @MockBean private ModelMapper modelMapper;

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
    Page<AccidentDTO> result =  this.accidentService.findByStartPointWithin(polygon);

    // Assert
    Assertions.assertNotNull(result.get());
    Mockito.verify(accidentRepository, Mockito.times(1)).findByStartPointWithin(Mockito.any(), Mockito.any());
    Mockito.verify(modelMapper, Mockito.times(1)).map(Mockito.any(), Mockito.any());
  }

  @Test
  void findByStartPointWithinCircleThrowsException() {
    // Arrange
    Circle circle = new Circle(new Point(0.1,0.1), 0.1);
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
    Circle circle = new Circle(new Point(0.1,0.1), 0.1);
    AccidentDTO accidentDTO = AccidentDTOFixture.withDefaults();
    Accident accident = AccidentFixture.withDefaults();
    List<Accident> accidentList = newArrayList(accident);
    Page<Accident> accidents = new PageImpl<>(accidentList);

    Mockito.when(accidentRepository.findByStartPointWithin(Mockito.any(), Mockito.any())).thenReturn(accidents);

    Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(accidentDTO);

    // Act
    Page<AccidentDTO> result =  this.accidentService.findByStartPointWithin(circle);

    // Assert
    Assertions.assertNotNull(result.get());
    Mockito.verify(accidentRepository, Mockito.times(1)).findByStartPointWithin(Mockito.any(), Mockito.any());
    Mockito.verify(modelMapper, Mockito.times(1)).map(Mockito.any(), Mockito.any());
  }

}
