package com.unlp.bbdd2.accidents.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AccidentDTO {
    private String id;
    private String accidentId;
    private PointDTO startPoint;
    private PointDTO stopPoint;
    private Integer severity;
    private String source;
    private LocalDateTime startTime;
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
    private String airportCode;
    private LocalDateTime weatherTimestamp;
    private Double tmc;
    private Double distance;
    private Double temperature;
    private Double windChill;
    private Double humidity;
    private Double pressure;
    private Double visibility;
    private String weatherCondition;
    private Double precipitation;
    private Double windSpeed;
    private String windDirection;
    private Boolean amenity;
    private Boolean bump;
    private Boolean crossing;
    private Boolean giveWay;
    private Boolean juntion;
    private Boolean noExit;
    private Boolean railway;
    private Boolean roundabout;
    private Boolean station;
    private Boolean stop;
    private Boolean trafficCalming;
    private Boolean trafficSignal;
    private Boolean turningLoop;
    private String sunriseSunset;
    private String civilTwilight;
    private String nauticalTwilight;
    private String astronomicalTwilight;
}
