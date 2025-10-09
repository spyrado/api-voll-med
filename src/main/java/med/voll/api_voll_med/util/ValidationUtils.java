package med.voll.api_voll_med.util;

import med.voll.api_voll_med.model.dto.error.ErrorResponseDTO;
import org.springframework.validation.FieldError;

public class ValidationUtils {

  public static ErrorResponseDTO toErrorResponse(FieldError fieldError) {
    return new ErrorResponseDTO(
            fieldError.getField(),
            fieldError.getRejectedValue(),
            fieldError.getDefaultMessage()
    );
  }
}
