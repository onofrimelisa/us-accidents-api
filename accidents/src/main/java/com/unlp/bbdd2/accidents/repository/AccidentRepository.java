package com.unlp.bbdd2.accidents.repository;

import com.unlp.bbdd2.accidents.model.Accident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {
    Accident findByAccidentId(String accidentId);
}
