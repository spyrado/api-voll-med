package med.voll.api_voll_med.controller;

import jakarta.validation.Valid;
import med.voll.api_voll_med.model.dto.medico.DadosCadastraisMedicoDTO;
import med.voll.api_voll_med.model.dto.medico.DadosListagemMedicoDTO;
import med.voll.api_voll_med.model.entity.Medico;
import med.voll.api_voll_med.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
  /*
   * @Autowired: Injeção automática de dependência pelo Spring.
   * O Spring cria e injeta uma instância do MedicoRepository aqui,
   * permitindo acessar métodos de banco sem precisar instanciar manualmente.
   * em resumo ao inves de precisar fazer algo como: new MedicoRepository()
   * o @Autowired já fica encarregado de fazer isso pra você por dbaixo dos panos
   */
  @Autowired
  private MedicoRepository medicoRepository;

  @Transactional
  @PostMapping
  public void cadastrar(@Valid @RequestBody DadosCadastraisMedicoDTO dadosCadastraisMedicoDTO) {
    medicoRepository.save(new Medico(dadosCadastraisMedicoDTO));
  }

  @GetMapping
  public List<DadosListagemMedicoDTO> listar() {
    return medicoRepository
            .findAll()
            .stream()
            .map(DadosListagemMedicoDTO::new)
            .toList();
  }
}
