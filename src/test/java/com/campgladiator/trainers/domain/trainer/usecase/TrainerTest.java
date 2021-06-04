package com.campgladiator.trainers.domain.trainer.usecase;

import com.campgladiator.trainers.domain.trainer.model.Trainer;

public abstract class TrainerTest {

  static final String TRAINER_ID = "000001";
  static final String TRAINER_EMAIL = "test@gmail.com";
  static final String TRAINER_PHONE = "5555-5555";
  static final String TRAINER_FIRST_NAME = "John";
  static final String TRAINER_LAST_NAME = "Doe";

  Trainer getTrainerWithId() {
    return Trainer.builder()
        .id(TRAINER_ID)
        .email(TRAINER_EMAIL)
        .phone(TRAINER_PHONE)
        .firstName(TRAINER_FIRST_NAME)
        .lastName(TRAINER_LAST_NAME)
        .build();
  }

  Trainer getTrainerInput() {
    return Trainer.builder()
        .email(TRAINER_EMAIL)
        .phone(TRAINER_PHONE)
        .firstName(TRAINER_FIRST_NAME)
        .lastName(TRAINER_LAST_NAME)
        .build();
  }
}
