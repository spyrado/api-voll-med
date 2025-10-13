package med.voll.api_voll_med.model.dto.medico;

import med.voll.api_voll_med.model.dto.endereco.EnderecoDTO;

public record DadosAtualizacaoMeditoDTO(
        String nome,
        String telefone,
        EnderecoDTO endereco
) {
}
