package com.unlp.bbdd2.accidents.dto;
import java.time.LocalDateTime;

public class AccidentDTOFixture {

  private final PointDTO testPoint = new PointDTO(1.0, 1.0);
  private final LocalDateTime testDate = LocalDateTime.MIN;

  String id = "test-id";
  String accidentId = "test-accidentId";
  PointDTO startPoint = testPoint;
  PointDTO stopPoint = testPoint;
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

  public static AccidentDTO withDefaults() {
    return AccidentDTOFixture.anAccidentDTOFixture().build();
  }

  public static AccidentDTOFixture anAccidentDTOFixture() {
    return new AccidentDTOFixture();
  }

  public AccidentDTOFixture withId(String id) {
    this.id = id;
    return this;
  }

  public AccidentDTOFixture withAccidentDTOId(String accidentId) {
    this.accidentId = accidentId;
    return this;
  }

  public AccidentDTOFixture withStartPoint(PointDTO startPoint) {
    this.startPoint = startPoint;
    return this;
  }

  public AccidentDTOFixture withStopPoint(PointDTO stopPoint) {
    this.stopPoint = stopPoint;
    return this;
  }

  public AccidentDTOFixture withSeverity(Integer severity) {
    this.severity = severity;
    return this;
  }

  public AccidentDTOFixture withSource(String source) {
    this.source = source;
    return this;
  }

  public AccidentDTOFixture withStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  public AccidentDTOFixture withEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  public AccidentDTOFixture withDescription(String description) {
    this.description = description;
    return this;
  }

  public AccidentDTOFixture withNumber(String number) {
    this.number = number;
    return this;
  }

  public AccidentDTOFixture withStreet(String street) {
    this.street = street;
    return this;
  }

  public AccidentDTOFixture withSide(String side) {
    this.side = side;
    return this;
  }

  public AccidentDTOFixture withCity(String city) {
    this.city = city;
    return this;
  }

  public AccidentDTOFixture withCounty(String county) {
    this.county = county;
    return this;
  }

  public AccidentDTOFixture withState(String state) {
    this.state = state;
    return this;
  }

  public AccidentDTOFixture withZipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }

  public AccidentDTOFixture withCountry(String country) {
    this.country = country;
    return this;
  }

  public AccidentDTOFixture withTimezone(String timezone) {
    this.timezone = timezone;
    return this;
  }

  public AccidentDTOFixture withAirportCode(String airportCode) {
    this.airportCode = airportCode;
    return this;
  }

  public AccidentDTOFixture withWeatherTimestamp(LocalDateTime weatherTimestamp) {
    this.weatherTimestamp = weatherTimestamp;
    return this;
  }

  public AccidentDTOFixture withTmc(Double tmc) {
    this.tmc = tmc;
    return this;
  }

  public AccidentDTOFixture withDistance(Double distance) {
    this.distance = distance;
    return this;
  }

  public AccidentDTOFixture withTemperature(Double temperature) {
    this.temperature = temperature;
    return this;
  }

  public AccidentDTOFixture withWindChill(Double windChill) {
    this.windChill = windChill;
    return this;
  }

  public AccidentDTOFixture withHumidity(Double humidity) {
    this.humidity = humidity;
    return this;
  }

  public AccidentDTOFixture withPressure(Double pressure) {
    this.pressure = pressure;
    return this;
  }

  public AccidentDTOFixture withVisibility(Double visibility) {
    this.visibility = visibility;
    return this;
  }

  public AccidentDTOFixture withWeatherCondition(String weatherCondition) {
    this.weatherCondition = weatherCondition;
    return this;
  }

  public AccidentDTOFixture withPrecipitation(Double precipitation) {
    this.precipitation = precipitation;
    return this;
  }

  public AccidentDTOFixture withWindSpeed(Double windSpeed) {
    this.windSpeed = windSpeed;
    return this;
  }

  public AccidentDTOFixture withWindDirection(String windDirection) {
    this.windDirection = windDirection;
    return this;
  }

  public AccidentDTOFixture withAmenity(Boolean amenity) {
    this.amenity = amenity;
    return this;
  }

  public AccidentDTOFixture withBump(Boolean bump) {
    this.bump = bump;
    return this;
  }

  public AccidentDTOFixture withCrossing(Boolean crossing) {
    this.crossing = crossing;
    return this;
  }

  public AccidentDTOFixture withGiveWay(Boolean giveWay) {
    this.giveWay = giveWay;
    return this;
  }

  public AccidentDTOFixture withJuntion(Boolean juntion) {
    this.juntion = juntion;
    return this;
  }

  public AccidentDTOFixture withNoExit(Boolean noExit) {
    this.noExit = noExit;
    return this;
  }

  public AccidentDTOFixture withRailway(Boolean railway) {
    this.railway = railway;
    return this;
  }

  public AccidentDTOFixture withRoundabout(Boolean roundabout) {
    this.roundabout = roundabout;
    return this;
  }

  public AccidentDTOFixture withStation(Boolean station) {
    this.station = station;
    return this;
  }

  public AccidentDTOFixture withStop(Boolean stop) {
    this.stop = stop;
    return this;
  }

  public AccidentDTOFixture withTrafficCalming(Boolean trafficCalming) {
    this.trafficCalming = trafficCalming;
    return this;
  }

  public AccidentDTOFixture withTrafficSignal(Boolean trafficSignal) {
    this.trafficSignal = trafficSignal;
    return this;
  }

  public AccidentDTOFixture withTurningLoop(Boolean turningLoop) {
    this.turningLoop = turningLoop;
    return this;
  }

  public AccidentDTOFixture withSunriseSunset(String sunriseSunset) {
    this.sunriseSunset = sunriseSunset;
    return this;
  }

  public AccidentDTOFixture withCivilTwilight(String civilTwilight) {
    this.civilTwilight = civilTwilight;
    return this;
  }

  public AccidentDTOFixture withNauticalTwilight(String nauticalTwilight) {
    this.nauticalTwilight = nauticalTwilight;
    return this;
  }

  public AccidentDTOFixture withAstronomicalTwilight(String astronomicalTwilight) {
    this.astronomicalTwilight = astronomicalTwilight;
    return this;
  }

  public AccidentDTO build() {
    AccidentDTO accidentDTO = new AccidentDTO();
    accidentDTO.setTrafficCalming(this.trafficCalming);
    accidentDTO.setZipcode(this.zipcode);
    accidentDTO.setStartTime(this.startTime);
    accidentDTO.setTimezone(this.timezone);
    accidentDTO.setWindSpeed(this.windSpeed);
    accidentDTO.setDescription(this.description);
    accidentDTO.setStopPoint(this.stopPoint);
    accidentDTO.setStation(this.station);
    accidentDTO.setHumidity(this.humidity);
    accidentDTO.setAstronomicalTwilight(this.astronomicalTwilight);
    accidentDTO.setStartPoint(this.startPoint);
    accidentDTO.setEndTime(this.endTime);
    accidentDTO.setBump(this.bump);
    accidentDTO.setNumber(this.number);
    accidentDTO.setState(this.state);
    accidentDTO.setNoExit(this.noExit);
    accidentDTO.setSunriseSunset(this.sunriseSunset);
    accidentDTO.setSource(this.source);
    accidentDTO.setTurningLoop(this.turningLoop);
    accidentDTO.setStop(this.stop);
    accidentDTO.setDistance(this.distance);
    accidentDTO.setStreet(this.street);
    accidentDTO.setWeatherTimestamp(this.weatherTimestamp);
    accidentDTO.setTmc(this.tmc);
    accidentDTO.setSide(this.side);
    accidentDTO.setWeatherCondition(this.weatherCondition);
    accidentDTO.setCounty(this.county);
    accidentDTO.setNauticalTwilight(this.nauticalTwilight);
    accidentDTO.setWindChill(this.windChill);
    accidentDTO.setCountry(this.country);
    accidentDTO.setCrossing(this.crossing);
    accidentDTO.setVisibility(this.visibility);
    accidentDTO.setJuntion(this.juntion);
    accidentDTO.setPressure(this.pressure);
    accidentDTO.setTemperature(this.temperature);
    accidentDTO.setAccidentId(this.accidentId);
    accidentDTO.setSeverity(this.severity);
    accidentDTO.setRoundabout(this.roundabout);
    accidentDTO.setCivilTwilight(this.civilTwilight);
    accidentDTO.setTrafficSignal(this.trafficSignal);
    accidentDTO.setGiveWay(this.giveWay);
    accidentDTO.setRailway(this.railway);
    accidentDTO.setId(this.id);
    accidentDTO.setWindDirection(this.windDirection);
    accidentDTO.setAirportCode(this.airportCode);
    accidentDTO.setPrecipitation(this.precipitation);
    accidentDTO.setAmenity(this.amenity);
    accidentDTO.setCity(this.city);

    return accidentDTO;
  }
}
