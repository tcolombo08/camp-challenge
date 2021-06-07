package com.campgladiator.trainers.adapter.in.api.trainer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerCreationRequest {

  private String email;
  private String phone;
  private String firstName;
  private String lastName;
}
