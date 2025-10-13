package med.voll.api_voll_med.model.dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import med.voll.api_voll_med.enums.EspecialidadeEnum;
import med.voll.api_voll_med.model.dto.endereco.EnderecoDTO;
import med.voll.api_voll_med.model.entity.Medico;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DadosCadastraisMedicoDTO {

  private Long id;

  @NotBlank(message = "campo obrigatório.")
  private String nome;

  @NotBlank(message = "campo obrigatório.")
  private String email;

  @NotBlank(message = "campo obrigatório.")
  private String telefone;

  @NotBlank(message = "campo obrigatório.")
  @Pattern(regexp = "^\\d{4,6}$", message = "o valor deve der no mínimo 4 e no máximo 6 digitos.")
  private String crm;

  @NotNull(message = "campo obrigatório")
  private EspecialidadeEnum especialidade;

  @NotNull(message = "campo obrigatório")
  @Valid
  private EnderecoDTO endereco;

  public DadosCadastraisMedicoDTO(Medico medico) {
    this.id = medico.getId();
    this.nome = medico.getNome();
    this.email = medico.getEmail();
    this.telefone = medico.getTelefone();
    this.crm = medico.getCrm();
    this.especialidade = medico.getEspecialidade();
    this.endereco = new EnderecoDTO(medico);
  }

}
