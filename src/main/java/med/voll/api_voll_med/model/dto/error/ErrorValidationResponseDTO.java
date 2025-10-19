package med.voll.api_voll_med.model.dto.error;

import org.springframework.http.HttpStatus;

public class ErrorValidationResponseDTO extends ErrorBase {
  String campo;
  Object valorRejeitado;

  public ErrorValidationResponseDTO(String campo, Object valorRejeitado, String mensagem) {
    super(HttpStatus.BAD_REQUEST, mensagem);
    this.campo = campo;
    this.valorRejeitado = valorRejeitado;
  }
}
