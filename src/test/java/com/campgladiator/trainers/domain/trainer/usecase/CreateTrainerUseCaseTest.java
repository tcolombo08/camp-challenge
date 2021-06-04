package com.campgladiator.trainers.domain.trainer.usecase;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.campgladiator.trainers.adapter.in.api.trainer.model.TrainerCreationRequest;
import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.CreateTrainerPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateTrainerUseCaseTest extends TrainerTest{

  @Mock
  CreateTrainerPort createTrainerPort;
  @InjectMocks
  CreateTrainerUseCase createTrainerUseCase;

  @Test
  void create_withNullCommand() {
    assertThatThrownBy(() -> createTrainerUseCase.create(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void create() {
    TrainerCreationRequest trainerCreationRequest = TrainerCreationRequest.builder().email(TRAINER_EMAIL)
        .phone(TRAINER_PHONE).firstName(TRAINER_FIRST_NAME).lastName(TRAINER_LAST_NAME).build();

    Trainer trainerWithId = getTrainerWithId();

    when(createTrainerPort.create(getTrainerInput())).thenReturn(trainerWithId);
    Trainer trainerResponse = createTrainerUseCase.create(trainerCreationRequest);
    assertNotNull(trainerResponse);
    assertEquals(trainerResponse, trainerWithId);
  }


}