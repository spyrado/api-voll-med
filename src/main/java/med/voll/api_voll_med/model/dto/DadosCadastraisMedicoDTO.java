package med.voll.api_voll_med.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import med.voll.api_voll_med.enums.EspecialidadeEnum;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DadosCadastraisMedicoDTO {

  @NotBlank(message = "campo obrigatório.")
  private String nome;
  @NotBlank(message = "campo obrigatório.")
  private String email;
  @NotBlank(message = "campo obrigatório.")
  private String crm;
  @NotNull(message = "campo obrigatório")
  private EspecialidadeEnum especialidade;
  @NotNull(message = "campo obrigatório")
  private EnderecoDTO endereco;

}
