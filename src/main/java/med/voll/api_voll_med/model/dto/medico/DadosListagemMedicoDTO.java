package med.voll.api_voll_med.model.dto.medico;

import med.voll.api_voll_med.enums.EspecialidadeEnum;
import med.voll.api_voll_med.model.entity.Medico;

public record DadosListagemMedicoDTO(String nome, String email, String crm, EspecialidadeEnum especialidade) {

  public DadosListagemMedicoDTO(Medico medico) {
    this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
  }
}
