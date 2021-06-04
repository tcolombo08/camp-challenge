package com.campgladiator.trainers.adapter.out.trainer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDto {
  private String id;
  private String email;
  private String phoneNumber;
  private String firstName;
  private String lastName;
}
