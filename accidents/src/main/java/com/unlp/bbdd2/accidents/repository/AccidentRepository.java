package com.unlp.bbdd2.accidents.repository;

import com.unlp.bbdd2.accidents.model.Accident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AccidentRepository extends ElasticsearchRepository<Accident, String> {

    Page<Accident> findAll(Pageable pageable);

    Page<Accident> findByAirportCode(String airportCode, Pageable pageable);


}
