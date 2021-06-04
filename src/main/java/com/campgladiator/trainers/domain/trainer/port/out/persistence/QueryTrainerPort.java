package com.campgladiator.trainers.domain.trainer.port.out.persistence;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import java.util.List;
import java.util.Optional;

public interface QueryTrainerPort {

  Optional<Trainer> findById(String trainerId);
  List<Trainer> findAll();
}
