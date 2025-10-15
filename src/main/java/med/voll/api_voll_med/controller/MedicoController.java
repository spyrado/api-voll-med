package med.voll.api_voll_med.controller;

import jakarta.validation.Valid;
import med.voll.api_voll_med.model.dto.medico.DadosAtualizacaoMeditoDTO;
import med.voll.api_voll_med.model.dto.medico.DadosCadastraisMedicoDTO;
import med.voll.api_voll_med.model.dto.medico.DadosListagemMedicoDTO;
import med.voll.api_voll_med.model.entity.Medico;
import med.voll.api_voll_med.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
  @Transactional
  public ResponseEntity<DadosCadastraisMedicoDTO> cadastrar(@RequestBody @Valid DadosCadastraisMedicoDTO dadosCadastraisMedicoDTO) {
    Medico medico = medicoRepository.save(new Medico(dadosCadastraisMedicoDTO));
    URI uri = URI.create("/medicos/" + medico.getId());
    return ResponseEntity
        .created(uri)
        .body(new DadosCadastraisMedicoDTO(medico));
  }

  @GetMapping
  public Page<DadosListagemMedicoDTO> listar(Pageable pageable) {
    return medicoRepository
        .findAll(pageable)
        .map(DadosListagemMedicoDTO::new);
  }

  @PutMapping("{id}")
  @Transactional
  public ResponseEntity<DadosCadastraisMedicoDTO> atualizar(
      @PathVariable Long id,
      @RequestBody @Valid DadosAtualizacaoMeditoDTO dadosAtualizacaoMeditoDTO) {
    var medico = medicoRepository.getReferenceById(id);
    medico.atualizarInformacoes(dadosAtualizacaoMeditoDTO);
    var medicoDTO = new DadosCadastraisMedicoDTO(medico);
    return ResponseEntity.ok(medicoDTO);
  }

  @DeleteMapping("{id}")
  @Transactional
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    medicoRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}
