package com.campgladiator.trainers.domain.trainer.usecase;

import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.QueryTrainerPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindTrainerUseCaseTest extends TrainerTest {

  @Mock QueryTrainerPort queryTrainerPort;
  @InjectMocks FindTrainerUseCase findTrainerUseCase;

  @Test
  void find_withNullId() {
    assertThatThrownBy(() -> findTrainerUseCase.find(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void find() {
    Mockito.when(queryTrainerPort.findById(TRAINER_ID)).thenReturn(of(getTrainerWithId()));
    Trainer trainerResponse = findTrainerUseCase.find(TRAINER_ID);
    assertNotNull(trainerResponse);
    assertEquals(trainerResponse.getId(), TRAINER_ID);
  }
}
