package com.unlp.bbdd2.accidents.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.math.BigInteger;

@Data
@Setter
@Builder
public class TemperatureDTO {
    private String criteria;
    private Double threshold;
    private BigInteger totalAccidents;
}
