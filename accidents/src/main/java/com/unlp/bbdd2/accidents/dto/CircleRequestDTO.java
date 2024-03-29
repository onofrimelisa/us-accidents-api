package com.unlp.bbdd2.accidents.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class CircleRequestDTO {

  @NotNull(message = "The point must not be null.")
  @Valid
  PointDTO point;
  @NotNull(message = "The radius must not be null.")
  @Positive(message = "The radius value must be positive.")
  Double radius;
}
