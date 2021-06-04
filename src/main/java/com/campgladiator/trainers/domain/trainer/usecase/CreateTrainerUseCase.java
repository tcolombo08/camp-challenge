package com.campgladiator.trainers.domain.trainer.usecase;

import static org.springframework.util.Assert.*;

import com.campgladiator.trainers.adapter.in.api.trainer.model.TrainerCreationRequest;
import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.CreateTrainerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class CreateTrainerUseCase {

  private final CreateTrainerPort createTrainerPort;

  public Trainer create(final TrainerCreationRequest trainerCreationRequest) {
    notNull(trainerCreationRequest, "trainerCreationRequest cannot be null");
    final Trainer trainer = Trainer.builder().email(trainerCreationRequest.getEmail())
        .phone(trainerCreationRequest.getPhone()).firstName(trainerCreationRequest.getFirstName())
        .lastName(trainerCreationRequest.getLastName()).build();
      return createTrainerPort.create(trainer);
  }
}
