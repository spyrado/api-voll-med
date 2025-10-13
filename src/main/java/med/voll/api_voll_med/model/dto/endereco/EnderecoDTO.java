package med.voll.api_voll_med.model.dto.endereco;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import med.voll.api_voll_med.model.entity.Medico;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnderecoDTO {

  @NotBlank(message = "campo obrigatório.")
  private String logradouro;
  @NotBlank(message = "campo obrigatório.")
  private String bairro;
  @NotBlank(message = "campo obrigatório.")
  @Pattern(regexp = "^\\d{8}$", message = "o cep deve ter 8 digitos")
  private String cep;
  @NotBlank(message = "campo obrigatório.")
  private String cidade;
  @NotBlank(message = "campo obrigatório.")
  private String uf;
  @Nullable
  private String numero;
  @Nullable
  private String complemento;

  public EnderecoDTO(Medico medico) {
    this.logradouro = medico.getEndereco().getLogradouro();
    this.bairro = medico.getEndereco().getBairro();
    this.cep = medico.getEndereco().getCep();
    this.cidade = medico.getEndereco().getCidade();
    this.uf = medico.getEndereco().getUf();
    this.numero = medico.getEndereco().getNumero();
    this.complemento = medico.getEndereco().getComplemento();
  }
}
