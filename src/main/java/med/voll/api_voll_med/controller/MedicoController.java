package med.voll.api_voll_med.controller;

import med.voll.api_voll_med.model.dto.DadosCadastraisMedicoDTO;
import med.voll.api_voll_med.model.entity.Medico;
import med.voll.api_voll_med.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @PostMapping
  public void cadastrar(@RequestBody DadosCadastraisMedicoDTO dadosCadastraisMedicoDTO) {
    medicoRepository.save(new Medico(dadosCadastraisMedicoDTO));
  }
}
