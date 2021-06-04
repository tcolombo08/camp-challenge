package com.campgladiator.trainers.adapter.in.api.trainer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.With;

@Data
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerCreationRequestDTO {

  @NonNull private String email;
  @NonNull private String phone;
  @NonNull private String firstName;
  @NonNull private String lastName;

}
