package com.campgladiator.trainers.adapter.out.trainer.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

  private LocalDateTime timestamp;
  private int status;
  private String error;
  private String message;
  private String path;
}
