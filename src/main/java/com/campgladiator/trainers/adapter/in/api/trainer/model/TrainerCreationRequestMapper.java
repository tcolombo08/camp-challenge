package com.campgladiator.trainers.adapter.in.api.trainer.model;

import org.springframework.stereotype.Component;

@Component
public class TrainerCreationRequestMapper {

  public TrainerCreationRequest map(TrainerCreationRequestDTO creationRequestDto) {
    return TrainerCreationRequest.builder()
        .email(creationRequestDto.getEmail())
        .phone(creationRequestDto.getPhone())
        .firstName(creationRequestDto.getFirstName())
        .lastName(creationRequestDto.getLastName())
        .build();
  }
}
