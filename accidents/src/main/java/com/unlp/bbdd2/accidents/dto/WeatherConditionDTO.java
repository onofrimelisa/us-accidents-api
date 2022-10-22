package com.unlp.bbdd2.accidents.dto;

import lombok.Data;
import lombok.Setter;

import java.math.BigInteger;

@Data
@Setter
public class WeatherConditionDTO {
    private String weatherCondition;
    private BigInteger totalAccidents;
}
