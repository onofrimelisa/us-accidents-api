package com.unlp.bbdd2.accidents.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Data
@Document
public class WeatherConditionAggregation {
    @Id
    private String id;

    @Field("total_accidents")
    private BigInteger totalAccidents;

}
