package med.voll.api_voll_med.exception.handler;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api_voll_med.model.dto.error.ErrorInternalServerError;
import med.voll.api_voll_med.model.dto.error.ErrorValidationResponseDTO;
import med.voll.api_voll_med.util.ValidationUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorValidationResponseDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    List<ErrorValidationResponseDTO> errors = ex
        .getBindingResult()
        .getFieldErrors()
        .stream()
        .map(ValidationUtils::toErrorResponse)
        .toList();
    return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<List<ErrorInternalServerError>> handleEntityNotFoundException(EntityNotFoundException ex) {
    return ResponseEntity.internalServerError().body(List.of(ErrorInternalServerError.of("Recurso não encontrado.")));
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<List<ErrorInternalServerError>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
    return ResponseEntity.internalServerError().body(List.of(ErrorInternalServerError.of("Não foi possível processar a operação devido a um conflito de dados. Verifique os campos e tente novamente")));
  }
}
