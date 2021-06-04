package com.campgladiator.trainers.domain.trainer.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.QueryTrainerPort;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListTrainersUseCaseTest extends TrainerTest {

  @Mock QueryTrainerPort queryTrainerPort;
  @InjectMocks ListTrainersUseCase listTrainersUseCase;

  @Test
  void findAll() {
    Mockito.when(queryTrainerPort.findAll()).thenReturn(List.of(getTrainerWithId()));
    List<Trainer> trainers = listTrainersUseCase.findAll();
    assertNotNull(trainers);
    assertEquals(trainers.get(0).getId(), TRAINER_ID);
  }
}
