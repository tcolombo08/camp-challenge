package com.campgladiator.trainers.adapter.out.trainer.model;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import org.springframework.stereotype.Component;

@Component
public class TrainerDtoMapper {

  public TrainerDto map(Trainer trainer) {
    return TrainerDto.builder()
        .id(trainer.getId())
        .email(trainer.getEmail())
        .phoneNumber(trainer.getPhone())
        .firstName(trainer.getFirstName())
        .lastName(trainer.getLastName())
        .build();
  }
}
