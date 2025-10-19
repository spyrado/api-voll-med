package med.voll.api_voll_med.model.dto.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Getter
public class ErrorBase {

  private static final Logger logger = LoggerFactory.getLogger(ErrorBase.class);

  private final HttpStatus status;
  private final String mensagem;
  private final UUID codigoDoErro;

  public ErrorBase(HttpStatus status, String mensagem) {
    this.status = status;
    this.mensagem = mensagem;
    this.codigoDoErro = UUID.randomUUID();
    logger.error("Código do erro: {}", this.codigoDoErro);
  }

  @JsonProperty("status")
  public int getStatusCode() {
    return status.value();
  }
}
