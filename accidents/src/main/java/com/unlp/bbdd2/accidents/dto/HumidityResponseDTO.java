package com.unlp.bbdd2.accidents.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Builder
public class HumidityResponseDTO {
    private String measurementType;
    private List<HumidityDTO> data;
}
