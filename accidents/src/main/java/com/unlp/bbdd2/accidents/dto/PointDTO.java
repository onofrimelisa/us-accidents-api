package com.unlp.bbdd2.accidents.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@AllArgsConstructor
public class PointDTO {

  @NotNull(message = "The X coordinate of the point must not be null.")

  private Double x;
  @NotNull(message = "The Y coordinate of the point must not be null.")
  private Double y;
}
