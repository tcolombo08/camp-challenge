package com.campgladiator.trainers.domain.trainer.usecase;

import static org.springframework.util.Assert.notNull;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.QueryTrainerPort;
import com.campgladiator.trainers.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class FindTrainerUseCase {
  private final QueryTrainerPort queryTrainerPort;

  public Trainer find(final String trainerId) {
    notNull(trainerId, "trainer id cannot be null");
    return queryTrainerPort
        .findById(trainerId)
        .orElseThrow(() -> new EntityNotFoundException("Trainer not found with id " + trainerId));
  }
}
