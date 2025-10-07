package med.voll.api_voll_med.model.dto;

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

  private String nome;
  private String email;
  private String crm;
  private EspecialidadeEnum especialidade;
  private EnderecoDTO endereco;

}
