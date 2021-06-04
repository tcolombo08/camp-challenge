package com.campgladiator.trainers.domain.trainer.port.out.persistence;

import com.campgladiator.trainers.domain.trainer.model.Trainer;

public interface CreateTrainerPort {

  Trainer create(Trainer trainer);
}
