package com.campgladiator.trainers.adapter.in.api.trainer;

import static com.campgladiator.trainers.adapter.in.api.trainer.TrainerController.PATH;

import com.campgladiator.trainers.adapter.in.api.trainer.model.TrainerCreationRequest;
import com.campgladiator.trainers.adapter.in.api.trainer.model.TrainerCreationRequestDTO;
import com.campgladiator.trainers.adapter.in.api.trainer.model.TrainerCreationRequestMapper;
import com.campgladiator.trainers.adapter.out.trainer.model.TrainerDto;
import com.campgladiator.trainers.adapter.out.trainer.model.TrainerDtoMapper;
import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.usecase.CreateTrainerUseCase;
import com.campgladiator.trainers.domain.trainer.usecase.FindTrainerUseCase;
import com.campgladiator.trainers.domain.trainer.usecase.ListTrainersUseCase;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = PATH)
@RequiredArgsConstructor
public class TrainerController {

  static final String PATH = "/api/v1/camp/trainer";
  private final CreateTrainerUseCase createTrainerUseCase;
  private final FindTrainerUseCase findTrainerUseCase;
  private final ListTrainersUseCase listTrainersUseCase;
  private final TrainerCreationRequestMapper trainerCreationRequestMapper;
  private final TrainerDtoMapper trainerDtoMapper;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public TrainerDto create(@RequestBody TrainerCreationRequestDTO creationRequestDto) {
    log.debug("Creating a Trainer... '{}'", () -> creationRequestDto);

    final TrainerCreationRequest creationRequest =
        trainerCreationRequestMapper.map(creationRequestDto);
    Trainer trainer = createTrainerUseCase.create(creationRequest);
    log.info(
        "Successfully created a trainer with id={} and email={}.",
        trainer.getId(),
        trainer.getEmail());
    return trainerDtoMapper.map(trainer);
  }

  @GetMapping("/{id}")
  public TrainerDto find(@PathVariable("id") String trainerId) {
    return trainerDtoMapper.map(findTrainerUseCase.find(trainerId));
  }

  @GetMapping()
  public List<TrainerDto> findAll() {
    return listTrainersUseCase.findAll().stream()
        .map(trainerDtoMapper::map)
        .collect(Collectors.toList());
  }
}
