package med.voll.api_voll_med.model.dto.error;

import org.springframework.http.HttpStatus;

public class ErrorInternalServerError extends ErrorBase {

  public ErrorInternalServerError(String mensagem) {
    super(HttpStatus.INTERNAL_SERVER_ERROR, mensagem);
  }

  public ErrorInternalServerError() {
    super(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor");
  }

  public static ErrorInternalServerError of(String mensagem) {
    return new ErrorInternalServerError(mensagem);
  }

  public static ErrorInternalServerError of() {
    return new ErrorInternalServerError();
  }
}
