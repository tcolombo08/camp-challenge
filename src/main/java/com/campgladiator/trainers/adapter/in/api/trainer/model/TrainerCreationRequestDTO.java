package com.campgladiator.trainers.adapter.in.api.trainer.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.validation.annotation.Validated;

@Data
@With
@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class TrainerCreationRequestDTO {

  @NotNull(message = "Email cannot be null")
  @Email(message = "Email should be valid")
  private String email;

  @NotNull(message = "Phone cannot be null")
  private String phone;

  @NotNull(message = "First name cannot be null")
  private String firstName;

  @NotNull(message = "Last name cannot be null")
  private String lastName;
}
