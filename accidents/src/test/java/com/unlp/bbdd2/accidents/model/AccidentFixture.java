package com.unlp.bbdd2.accidents.model;

import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import java.time.LocalDateTime;

public class AccidentFixture {
  private final Point testPoint = new Point(new Position(1.0,1.0));
  private final LocalDateTime testDate = LocalDateTime.MIN;

  String id = "test-id";
  String accidentId = "test-accidentId";
  Point startPoint = testPoint;
  Point stopPoint = testPoint;
  Integer severity = 0;
  String source = "test-source";
  LocalDateTime startTime = testDate;
  LocalDateTime endTime = testDate;
  String description = "test-description";
  String number = "test-number";
  String street = "test-street";
  String side = "test-side";
  String city = "test-city";
  String county = "test-county";
  String state = "test-state";
  String zipcode = "test-zipcode";
  String country = "test-country";
  String timezone = "test-timezone";
  String airportCode = "test-airportCode";
  LocalDateTime weatherTimestamp = testDate;
  Double tmc = 1.0;
  Double distance = 1.0;
  Double temperature = 1.0;
  Double windChill = 1.0;
  Double humidity = 1.0;
  Double pressure = 1.0;
  Double visibility = 1.0;
  String weatherCondition = "test-weatherCondition";
  Double precipitation = 1.0;
  Double windSpeed = 1.0;
  String windDirection = "test-windDirection";
  Boolean amenity = Boolean.FALSE;
  Boolean bump = Boolean.FALSE;
  Boolean crossing = Boolean.FALSE;
  Boolean giveWay = Boolean.FALSE;
  Boolean juntion = Boolean.FALSE;
  Boolean noExit = Boolean.FALSE;
  Boolean railway = Boolean.FALSE;
  Boolean roundabout = Boolean.FALSE;
  Boolean station = Boolean.FALSE;
  Boolean stop = Boolean.FALSE;
  Boolean trafficCalming = Boolean.FALSE;
  Boolean trafficSignal = Boolean.FALSE;
  Boolean turningLoop = Boolean.FALSE;
  String sunriseSunset = "test-sunriseSunset";
  String civilTwilight = "test-civilTwilight";
  String nauticalTwilight = "test-nauticalTwilight";
  String astronomicalTwilight = "test-astronomicalTwilight";

  public static Accident withDefaults() {
    return AccidentFixture.anAccidentFixture().build();
  }

  public static AccidentFixture anAccidentFixture() {
    return new AccidentFixture();
  }

  public AccidentFixture withId(String id) {
    this.id = id;
    return this;
  }

  public AccidentFixture withAccidentId(String accidentId) {
    this.accidentId = accidentId;
    return this;
  }

  public AccidentFixture withStartPoint(Point startPoint) {
    this.startPoint = startPoint;
    return this;
  }

  public AccidentFixture withStopPoint(Point stopPoint) {
    this.stopPoint = stopPoint;
    return this;
  }

  public AccidentFixture withSeverity(Integer severity) {
    this.severity = severity;
    return this;
  }

  public AccidentFixture withSource(String source) {
    this.source = source;
    return this;
  }

  public AccidentFixture withStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  public AccidentFixture withEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  public AccidentFixture withDescription(String description) {
    this.description = description;
    return this;
  }

  public AccidentFixture withNumber(String number) {
    this.number = number;
    return this;
  }

  public AccidentFixture withStreet(String street) {
    this.street = street;
    return this;
  }

  public AccidentFixture withSide(String side) {
    this.side = side;
    return this;
  }

  public AccidentFixture withCity(String city) {
    this.city = city;
    return this;
  }

  public AccidentFixture withCounty(String county) {
    this.county = county;
    return this;
  }

  public AccidentFixture withState(String state) {
    this.state = state;
    return this;
  }

  public AccidentFixture withZipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }

  public AccidentFixture withCountry(String country) {
    this.country = country;
    return this;
  }

  public AccidentFixture withTimezone(String timezone) {
    this.timezone = timezone;
    return this;
  }

  public AccidentFixture withAirportCode(String airportCode) {
    this.airportCode = airportCode;
    return this;
  }

  public AccidentFixture withWeatherTimestamp(LocalDateTime weatherTimestamp) {
    this.weatherTimestamp = weatherTimestamp;
    return this;
  }

  public AccidentFixture withTmc(Double tmc) {
    this.tmc = tmc;
    return this;
  }

  public AccidentFixture withDistance(Double distance) {
    this.distance = distance;
    return this;
  }

  public AccidentFixture withTemperature(Double temperature) {
    this.temperature = temperature;
    return this;
  }

  public AccidentFixture withWindChill(Double windChill) {
    this.windChill = windChill;
    return this;
  }

  public AccidentFixture withHumidity(Double humidity) {
    this.humidity = humidity;
    return this;
  }

  public AccidentFixture withPressure(Double pressure) {
    this.pressure = pressure;
    return this;
  }

  public AccidentFixture withVisibility(Double visibility) {
    this.visibility = visibility;
    return this;
  }

  public AccidentFixture withWeatherCondition(String weatherCondition) {
    this.weatherCondition = weatherCondition;
    return this;
  }

  public AccidentFixture withPrecipitation(Double precipitation) {
    this.precipitation = precipitation;
    return this;
  }

  public AccidentFixture withWindSpeed(Double windSpeed) {
    this.windSpeed = windSpeed;
    return this;
  }

  public AccidentFixture withWindDirection(String windDirection) {
    this.windDirection = windDirection;
    return this;
  }

  public AccidentFixture withAmenity(Boolean amenity) {
    this.amenity = amenity;
    return this;
  }

  public AccidentFixture withBump(Boolean bump) {
    this.bump = bump;
    return this;
  }

  public AccidentFixture withCrossing(Boolean crossing) {
    this.crossing = crossing;
    return this;
  }

  public AccidentFixture withGiveWay(Boolean giveWay) {
    this.giveWay = giveWay;
    return this;
  }

  public AccidentFixture withJuntion(Boolean juntion) {
    this.juntion = juntion;
    return this;
  }

  public AccidentFixture withNoExit(Boolean noExit) {
    this.noExit = noExit;
    return this;
  }

  public AccidentFixture withRailway(Boolean railway) {
    this.railway = railway;
    return this;
  }

  public AccidentFixture withRoundabout(Boolean roundabout) {
    this.roundabout = roundabout;
    return this;
  }

  public AccidentFixture withStation(Boolean station) {
    this.station = station;
    return this;
  }

  public AccidentFixture withStop(Boolean stop) {
    this.stop = stop;
    return this;
  }

  public AccidentFixture withTrafficCalming(Boolean trafficCalming) {
    this.trafficCalming = trafficCalming;
    return this;
  }

  public AccidentFixture withTrafficSignal(Boolean trafficSignal) {
    this.trafficSignal = trafficSignal;
    return this;
  }

  public AccidentFixture withTurningLoop(Boolean turningLoop) {
    this.turningLoop = turningLoop;
    return this;
  }

  public AccidentFixture withSunriseSunset(String sunriseSunset) {
    this.sunriseSunset = sunriseSunset;
    return this;
  }

  public AccidentFixture withCivilTwilight(String civilTwilight) {
    this.civilTwilight = civilTwilight;
    return this;
  }

  public AccidentFixture withNauticalTwilight(String nauticalTwilight) {
    this.nauticalTwilight = nauticalTwilight;
    return this;
  }

  public AccidentFixture withAstronomicalTwilight(String astronomicalTwilight) {
    this.astronomicalTwilight = astronomicalTwilight;
    return this;
  }

  public Accident build() {
    Accident accident = new Accident();
    accident.setTrafficCalming(this.trafficCalming);
    accident.setZipcode(this.zipcode);
    accident.setStartTime(this.startTime);
    accident.setTimezone(this.timezone);
    accident.setWindSpeed(this.windSpeed);
    accident.setDescription(this.description);
    accident.setStopPoint(this.stopPoint);
    accident.setStation(this.station);
    accident.setHumidity(this.humidity);
    accident.setAstronomicalTwilight(this.astronomicalTwilight);
    accident.setStartPoint(this.startPoint);
    accident.setEndTime(this.endTime);
    accident.setBump(this.bump);
    accident.setNumber(this.number);
    accident.setState(this.state);
    accident.setNoExit(this.noExit);
    accident.setSunriseSunset(this.sunriseSunset);
    accident.setSource(this.source);
    accident.setTurningLoop(this.turningLoop);
    accident.setStop(this.stop);
    accident.setDistance(this.distance);
    accident.setStreet(this.street);
    accident.setWeatherTimestamp(this.weatherTimestamp);
    accident.setTmc(this.tmc);
    accident.setSide(this.side);
    accident.setWeatherCondition(this.weatherCondition);
    accident.setCounty(this.county);
    accident.setNauticalTwilight(this.nauticalTwilight);
    accident.setWindChill(this.windChill);
    accident.setCountry(this.country);
    accident.setCrossing(this.crossing);
    accident.setVisibility(this.visibility);
    accident.setJuntion(this.juntion);
    accident.setPressure(this.pressure);
    accident.setTemperature(this.temperature);
    accident.setAccidentId(this.accidentId);
    accident.setSeverity(this.severity);
    accident.setRoundabout(this.roundabout);
    accident.setCivilTwilight(this.civilTwilight);
    accident.setTrafficSignal(this.trafficSignal);
    accident.setGiveWay(this.giveWay);
    accident.setRailway(this.railway);
    accident.setId(this.id);
    accident.setWindDirection(this.windDirection);
    accident.setAirportCode(this.airportCode);
    accident.setPrecipitation(this.precipitation);
    accident.setAmenity(this.amenity);
    accident.setCity(this.city);

    return accident;
  }
}
