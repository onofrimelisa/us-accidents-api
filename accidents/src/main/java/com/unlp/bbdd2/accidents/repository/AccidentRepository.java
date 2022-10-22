package com.unlp.bbdd2.accidents.repository;

import com.unlp.bbdd2.accidents.model.Accident;
import com.unlp.bbdd2.accidents.model.WeatherConditionAggregation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Shape;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {

  Accident findByAccidentId(String accidentId);

  Page<Accident> findByStartPointWithin(Shape shape, Pageable pageable);

  @Aggregation(pipeline = {
          "{'$match': { 'weather_condition': { $exists: true, $ne: null }} }",
          "{'$group': { _id: '$weather_condition', total_accidents: { $sum: 1 } }}",
          "{'$sort': { total_accidents: -1 }}",
          "{'$limit': ?0 }"
  })
  List<WeatherConditionAggregation> getMostCommonWeatherConditions(Integer limit);

}
