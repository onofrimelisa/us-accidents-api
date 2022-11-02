package com.unlp.bbdd2.accidents.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Data
@Document
public class HumidityAggregation {
    @Field("total_accidents")
    private BigInteger totalAccidents;

    @Field("range")
    private RangeAggregation range;

    @Data
    @Document
    private static class RangeAggregation {
        @Field("from")
        private Integer from;

        @Field("to")
        private Integer to;
    }
}
