package com.unlp.bbdd2.accidents.service;

import com.unlp.bbdd2.accidents.dto.AccidentDTO;
import com.unlp.bbdd2.accidents.exceptions.NotFoundException;
import com.unlp.bbdd2.accidents.model.Accident;
import com.unlp.bbdd2.accidents.repository.AccidentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

  public List<String> getMostCommonConditions() {
    return new ArrayList<>();
  }
}
