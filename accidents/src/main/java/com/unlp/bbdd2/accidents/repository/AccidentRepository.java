package com.unlp.bbdd2.accidents.repository;

import com.unlp.bbdd2.accidents.model.Accident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Shape;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {

  Accident findByAccidentId(String accidentId);

  Page<Accident> findByStartPointWithin(Shape shape, Pageable pageable);
}
