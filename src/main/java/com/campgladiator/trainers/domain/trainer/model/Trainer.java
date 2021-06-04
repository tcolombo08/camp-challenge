package com.campgladiator.trainers.domain.trainer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Trainer {

  @Id
  private String id;
  @Indexed(unique = true)
  private String email;
  private String phone;
  private String firstName;
  private String lastName;
}
