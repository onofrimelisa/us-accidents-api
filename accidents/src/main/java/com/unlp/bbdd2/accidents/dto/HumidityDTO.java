package com.unlp.bbdd2.accidents.dto;

import lombok.Data;
import lombok.Setter;

import java.math.BigInteger;

@Data
@Setter
public class HumidityDTO {
    private BigInteger totalAccidents;
    private RangeDTO range;

    @Data
    @Setter
    private static class RangeDTO {
        private Integer from;
        private Integer to;
    }
}
