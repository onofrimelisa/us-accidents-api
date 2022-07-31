package com.unlp.bbdd2.accidents.repository;

import com.unlp.bbdd2.accidents.model.Accident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {
    Accident findByAccidentId(String accidentId);
    Page<Accident> findByStartPointWithin(Polygon polygon, Pageable pageable);
    Page<Accident> findByStartPointWithin(Circle circle, Pageable pageable);
}
