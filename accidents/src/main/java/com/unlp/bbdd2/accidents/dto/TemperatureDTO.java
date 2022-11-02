package com.unlp.bbdd2.accidents.dto;

import lombok.*;

import java.math.BigInteger;

@Data
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemperatureDTO {
    private String criteria;
    private Double threshold;
    private BigInteger totalAccidents;
}
