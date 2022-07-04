package com.unlp.bbdd2.accidents.model;


import com.mongodb.client.model.geojson.Point;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(String accidentId) {
        this.accidentId = accidentId;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(Point stopPoint) {
        this.stopPoint = stopPoint;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public LocalDateTime getWeatherTimestamp() {
        return weatherTimestamp;
    }

    public void setWeatherTimestamp(LocalDateTime weatherTimestamp) {
        this.weatherTimestamp = weatherTimestamp;
    }

    public Double getTmc() {
        return tmc;
    }

    public void setTmc(Double tmc) {
        this.tmc = tmc;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWindChill() {
        return windChill;
    }

    public void setWindChill(Double windChill) {
        this.windChill = windChill;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Boolean getAmenity() {
        return amenity;
    }

    public void setAmenity(Boolean amenity) {
        this.amenity = amenity;
    }

    public Boolean getBump() {
        return bump;
    }

    public void setBump(Boolean bump) {
        this.bump = bump;
    }

    public Boolean getCrossing() {
        return crossing;
    }

    public void setCrossing(Boolean crossing) {
        this.crossing = crossing;
    }

    public Boolean getGiveWay() {
        return giveWay;
    }

    public void setGiveWay(Boolean giveWay) {
        this.giveWay = giveWay;
    }

    public Boolean getJuntion() {
        return juntion;
    }

    public void setJuntion(Boolean juntion) {
        this.juntion = juntion;
    }

    public Boolean getNoExit() {
        return noExit;
    }

    public void setNoExit(Boolean noExit) {
        this.noExit = noExit;
    }

    public Boolean getRailway() {
        return railway;
    }

    public void setRailway(Boolean railway) {
        this.railway = railway;
    }

    public Boolean getRoundabout() {
        return roundabout;
    }

    public void setRoundabout(Boolean roundabout) {
        this.roundabout = roundabout;
    }

    public Boolean getStation() {
        return station;
    }

    public void setStation(Boolean station) {
        this.station = station;
    }

    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    public Boolean getTrafficCalming() {
        return trafficCalming;
    }

    public void setTrafficCalming(Boolean trafficCalming) {
        this.trafficCalming = trafficCalming;
    }

    public Boolean getTrafficSignal() {
        return trafficSignal;
    }

    public void setTrafficSignal(Boolean trafficSignal) {
        this.trafficSignal = trafficSignal;
    }

    public Boolean getTurningLoop() {
        return turningLoop;
    }

    public void setTurningLoop(Boolean turningLoop) {
        this.turningLoop = turningLoop;
    }

    public String getSunriseSunset() {
        return sunriseSunset;
    }

    public void setSunriseSunset(String sunriseSunset) {
        this.sunriseSunset = sunriseSunset;
    }

    public String getCivilTwilight() {
        return civilTwilight;
    }

    public void setCivilTwilight(String civilTwilight) {
        this.civilTwilight = civilTwilight;
    }

    public String getNauticalTwilight() {
        return nauticalTwilight;
    }

    public void setNauticalTwilight(String nauticalTwilight) {
        this.nauticalTwilight = nauticalTwilight;
    }

    public String getAstronomicalTwilight() {
        return astronomicalTwilight;
    }

    public void setAstronomicalTwilight(String astronomicalTwilight) {
        this.astronomicalTwilight = astronomicalTwilight;
    }
}
