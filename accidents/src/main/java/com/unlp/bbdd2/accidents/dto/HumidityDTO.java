package com.unlp.bbdd2.accidents.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.math.BigInteger;

@Data
@Setter
@Builder
public class HumidityDTO {
    private BigInteger totalAccidents;
    private RangeDTO range;

    @Data
    @Setter
    @Builder
    public static class RangeDTO {
        private Integer from;
        private Integer to;
    }
}
