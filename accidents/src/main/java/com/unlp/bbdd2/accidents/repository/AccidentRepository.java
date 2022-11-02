package com.unlp.bbdd2.accidents.repository;

import com.unlp.bbdd2.accidents.model.*;
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

  @Aggregation(pipeline = {
          "{'$facet': { " +
                  "above: [" +
                    "{$match: {'temperature': {$gte: ?0}}}," +
                    "{$count: 'total_accidents'}," +
                    "{$addFields: {'criteria': 'ABOVE', 'threshold': ?0}}" +
                  "], " +
                  "below: [" +
                    "{$match: {'temperature': {$lt: ?0}}}," +
                    "{$count: 'total_accidents'}," +
                    "{$addFields: {'criteria': 'BELOW', 'threshold': ?0}}" +
                  "]}}",
          "{'$project': {'result': {$concatArrays:['$above', '$below']}}}",
          "{'$unwind': {path: '$result'}}",
          "{'$replaceRoot': {newRoot:'$result'}}"
  })
  List<TemperatureAggregation> getTotalAccidentsByTemperature(Double temperature);


  @Aggregation(pipeline = {
          "{'$facet': { " +
                  "'0': [" +
                    "{$match: {'humidity': {$gte: 0, $lt: 20} }}," +
                    "{$count: 'total_accidents'}," +
                    "{$addFields: {'range': {'from': 0, 'to': 20} }}" +
                  "], " +
                  "'20': [" +
                    "{$match: {'humidity': {$gte: 20, $lt: 40} }}," +
                    "{$count: 'total_accidents'}," +
                    "{$addFields: {'range': {'from': 20, 'to': 40} }}" +
                  "], " +
                  "'40': [" +
                    "{$match: {'humidity': {$gte: 40, $lt: 60} }}," +
                    "{$count: 'total_accidents'}," +
                    "{$addFields: {'range': {'from': 40, 'to': 60} }}" +
                  "], " +
                  "'60': [" +
                    "{$match: {'humidity': {$gte: 60, $lt: 80} }}," +
                    "{$count: 'total_accidents'}," +
                    "{$addFields: {'range': {'from': 60, 'to': 80} }}" +
                  "], " +
                  "'80': [" +
                    "{$match: {'humidity': {$gte: 80, $lte: 100} }}," +
                    "{$count: 'total_accidents'}," +
                    "{$addFields: {'range': {'from': 80, 'to': 100} }}" +
                  "]}}",
          "{'$project': {'result': {$concatArrays:['$0', '$20', '$40', '$60', '$80']}}}",
          "{'$unwind': {path: '$result'}}",
          "{'$replaceRoot': {newRoot:'$result'}}"
  })
  List<HumidityAggregation> getTotalAccidentsByHumidity();

}
