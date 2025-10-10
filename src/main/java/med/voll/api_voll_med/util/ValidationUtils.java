package med.voll.api_voll_med.util;

import med.voll.api_voll_med.model.dto.error.ErrorResponseDTO;
import org.springframework.validation.FieldError;

public class ValidationUtils {

  public static ErrorResponseDTO toErrorResponse(FieldError fieldError) {
    return new ErrorResponseDTO(
            ValidationUtils.alwaysGetLastProperty(fieldError.getField()),
            fieldError.getRejectedValue(),
            fieldError.getDefaultMessage()
    );
  }

  public static String alwaysGetLastProperty(String property) {

    String newProperty = "";

    if (property.contains(".")) {
      String[] splittedProperty = property.split("\\.");
      int lastIndexFromThisList = splittedProperty.length - 1;
      newProperty = splittedProperty[lastIndexFromThisList];
    } else {
      newProperty = property;
    }

    return newProperty;
  }
}
