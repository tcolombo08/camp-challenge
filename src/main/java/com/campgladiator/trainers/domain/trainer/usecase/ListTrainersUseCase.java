package com.campgladiator.trainers.domain.trainer.usecase;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.QueryTrainerPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ListTrainersUseCase {
  private final QueryTrainerPort queryTrainerPort;

  public List<Trainer> findAll () {
    return queryTrainerPort.findAll();
  }
}
