package com.campgladiator.trainers.adapter.out.trainer.persistence;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainerRepository extends MongoRepository<Trainer, String> {}
