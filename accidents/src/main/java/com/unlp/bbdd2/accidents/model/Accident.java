package com.unlp.bbdd2.accidents.model;


import com.mongodb.client.model.geojson.Point;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("accidents")
public class Accident {

  @Id
  private String id;

  @Field("accident_id")
  private String accidentId;
  @Field("start_point")
  private Point startPoint;
  @Field("stop_point")
  private Point stopPoint;
  private Integer severity;
  private String source;
  @Field("start_time")
  private LocalDateTime startTime;
  @Field("end_time")
  private LocalDateTime endTime;
  private String description;
  private String number;
  private String street;
  private String side;
  private String city;
  private String county;
  private String state;
  private String zipcode;
  private String country;
  private String timezone;
  @Field("airport_code")
  private String airportCode;
  @Field("weatherTimestamp")
  private LocalDateTime weatherTimestamp;
  private Double tmc;
  private Double distance;
  private Double temperature;
  @Field("wind_chill")
  private Double windChill;
  private Double humidity;
  private Double pressure;
  private Double visibility;
  @Field("weather_condition")
  private String weatherCondition;
  private Double precipitation;
  @Field("wind_speed")
  private Double windSpeed;
  @Field("wind_direction")
  private String windDirection;
  private Boolean amenity;
  private Boolean bump;
  private Boolean crossing;
  @Field("give_way")
  private Boolean giveWay;
  private Boolean juntion;
  @Field("no_exit")
  private Boolean noExit;
  private Boolean railway;
  private Boolean roundabout;
  private Boolean station;
  private Boolean stop;
  @Field("traffic_calming")
  private Boolean trafficCalming;
  @Field("traffic_signal")
  private Boolean trafficSignal;
  @Field("turning_loop")
  private Boolean turningLoop;
  @Field("sunrise_sunset")
  private String sunriseSunset;
  @Field("civil_twilight")
  private String civilTwilight;
  @Field("nautical_twilight")
  private String nauticalTwilight;
  @Field("astronomical_twilight")
  private String astronomicalTwilight;
}
