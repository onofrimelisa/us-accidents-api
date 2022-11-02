package com.unlp.bbdd2.accidents.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class PolygonRequestDTO {

  @Size(min = 4, message = "The list of points must have at least four elements.")
  @NotNull(message = "The list of points must not e null.")
  @Valid
  List<PointDTO> points;
}
