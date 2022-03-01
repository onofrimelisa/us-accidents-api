package com.unlp.bbdd2.accidents.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.math.BigDecimal;

@Document(indexName = "us_accidents")
public class Accident {

    @Id
    private String id;

    @Field("Airport_Code")
    private String airportCode;

    @Field("Amenity")
    private Boolean amenity;

    @Field("Astronomical_Twilight")
    private String astronomicalTwilight;

    @Field("Bump")
    private String bump;

    @Field("City")
    private String city;

    @Field("City_Twilight")
    private String cityTwilight;

    @Field("Country")
    private String country;

    @Field("County")
    private String county;

    @Field("Crossing")
    private String crossing;

    @Field("Description")
    private String description;

    @Field("Distance(mi)")
    private String distance;

    @Field("End_Lat")
    private String endLat;

    @Field("End_Lng")
    private String endLng;

    @Field("End_Time")
    private String endTime;

    @Field("Give_Way")
    private String giveWay;

    @Field("Humidity(%)")
    private String humidity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public Boolean getAmenity() {
        return amenity;
    }

    public void setAmenity(Boolean amenity) {
        this.amenity = amenity;
    }

    public String getAstronomicalTwilight() {
        return astronomicalTwilight;
    }

    public void setAstronomicalTwilight(String astronomicalTwilight) {
        this.astronomicalTwilight = astronomicalTwilight;
    }

    public String getBump() {
        return bump;
    }

    public void setBump(String bump) {
        this.bump = bump;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityTwilight() {
        return cityTwilight;
    }

    public void setCityTwilight(String cityTwilight) {
        this.cityTwilight = cityTwilight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCrossing() {
        return crossing;
    }

    public void setCrossing(String crossing) {
        this.crossing = crossing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getEndLat() {
        return endLat;
    }

    public void setEndLat(String endLat) {
        this.endLat = endLat;
    }

    public String getEndLng() {
        return endLng;
    }

    public void setEndLng(String endLng) {
        this.endLng = endLng;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGiveWay() {
        return giveWay;
    }

    public void setGiveWay(String giveWay) {
        this.giveWay = giveWay;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
