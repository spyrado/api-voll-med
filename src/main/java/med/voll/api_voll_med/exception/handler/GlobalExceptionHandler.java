package med.voll.api_voll_med.exception.handler;

import med.voll.api_voll_med.model.dto.error.ErrorResponseDTO;
import med.voll.api_voll_med.model.dto.error.ErrorResultResponse;
import med.voll.api_voll_med.util.ValidationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResultResponse<List<ErrorResponseDTO>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    List<ErrorResponseDTO> errorResponseList = ex
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .map(ValidationUtils::toErrorResponse)
            .toList();

    var apiResponse = new ErrorResultResponse<List<ErrorResponseDTO>>(HttpStatus.BAD_REQUEST.value(), errorResponseList);
    return ResponseEntity.badRequest().body(apiResponse);
  }
}
