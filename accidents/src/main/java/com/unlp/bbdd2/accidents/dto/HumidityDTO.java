package com.unlp.bbdd2.accidents.dto;

import lombok.*;

import java.math.BigInteger;

@Data
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HumidityDTO {
    private BigInteger totalAccidents;
    private RangeDTO range;

    @Data
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RangeDTO {
        private Integer from;
        private Integer to;
    }
}
