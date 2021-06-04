package com.campgladiator.trainers.config;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.campgladiator.trainers.adapter.out.trainer.model.ErrorDto;
import com.campgladiator.trainers.exception.EntityNotFoundException;
import com.mongodb.MongoWriteException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class ErrorHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(NOT_FOUND)
  public ErrorDto handleEntityNotFoundException(
      EntityNotFoundException ex, HttpServletRequest request) {
    return ErrorDto.builder()
        .timestamp(now())
        .status(NOT_FOUND.value())
        .error(NOT_FOUND.getReasonPhrase())
        .message(ex.getMessage())
        .path(request.getServletPath())
        .build();
  }

  @ResponseStatus(BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    return ex.getBindingResult().getAllErrors().stream()
        .map(ObjectError::getDefaultMessage)
        .collect(toList());
  }

  @ExceptionHandler(MongoWriteException.class)
  @ResponseStatus(BAD_REQUEST)
  public ErrorDto processMongoWriteError(MongoWriteException ex, HttpServletRequest request) {

    return ErrorDto.builder()
        .timestamp(now())
        .status(NOT_FOUND.value())
        .error(NOT_FOUND.getReasonPhrase())
        .message(ex.getMessage())
        .path(request.getServletPath())
        .build();
  }
}
