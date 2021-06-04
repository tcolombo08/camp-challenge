package com.campgladiator.trainers.adapter.out.trainer.persistence;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.CreateTrainerPort;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.QueryTrainerPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainerPersistenceAdapter implements QueryTrainerPort, CreateTrainerPort {

  private final TrainerRepository trainerRepository;

  @Override
  public Trainer create(Trainer trainer) {
    return trainerRepository.save(trainer);
  }

  @Override
  public Optional<Trainer> findById(String trainerId) {
    return trainerRepository.findById(trainerId);
  }

  @Override
  public List<Trainer> findAll() {
    return trainerRepository.findAll();
  }
}
