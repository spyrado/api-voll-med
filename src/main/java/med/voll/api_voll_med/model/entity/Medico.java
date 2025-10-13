package med.voll.api_voll_med.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api_voll_med.enums.EspecialidadeEnum;
import med.voll.api_voll_med.model.dto.medico.DadosAtualizacaoMeditoDTO;
import med.voll.api_voll_med.model.dto.medico.DadosCadastraisMedicoDTO;

/*
 * Define o nome da tabela no banco de dados.
 * Exemplo: cria ou usa a tabela chamada "medicos".
 */
@Table(name = "medicos")

/*
 * Indica que esta classe é uma entidade JPA (será mapeada para uma tabela).
 * Exemplo: cada objeto Medico será uma linha da tabela "medicos".
 */
@Entity(name = "Medico")

/*
 * Lombok gera automaticamente os getters (getId(), getNome(), etc.).
 * Exemplo: medico.getNome() funciona mesmo sem escrever o método manualmente.
 */
@Getter

/*
 * Lombok gera um construtor sem parâmetros.
 * Exemplo: public Medico() {}
 */
@NoArgsConstructor

/*
 * Lombok gera um construtor com todos os parâmetros.
 * Exemplo: new Medico(1L, "João", "joao@email.com", "1234", EspecialidadeEnum.CARDIOLOGIA, endereco)
 */
@AllArgsConstructor

/*
 * Lombok gera os métodos equals() e hashCode() comparando apenas o campo "id".
 * Exemplo: dois objetos Medico são considerados iguais se tiverem o mesmo id.
 */
@EqualsAndHashCode(of = "id")
public class Medico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String telefone;
  private String crm;

  @Enumerated(EnumType.STRING)
  private EspecialidadeEnum especialidade;


  @Embedded
  // significa que o endereço vai ficar junto da tabela de medicos, o jpa só vai diferenciar no codigo oq é endereço e oq é medico
  private Endereco endereco;

  public Medico(DadosCadastraisMedicoDTO dadosCadastraisMedicoDTO) {
    this.nome = dadosCadastraisMedicoDTO.getNome();
    this.email = dadosCadastraisMedicoDTO.getEmail();
    this.crm = dadosCadastraisMedicoDTO.getCrm();
    this.telefone = dadosCadastraisMedicoDTO.getTelefone();
    this.especialidade = dadosCadastraisMedicoDTO.getEspecialidade();
    this.endereco = new Endereco(dadosCadastraisMedicoDTO.getEndereco());
  }

  public void atualizarInformacoes(@Valid DadosAtualizacaoMeditoDTO dadosAtualizacaoMeditoDTO) {
    if (dadosAtualizacaoMeditoDTO.nome() != null) {
      this.nome = dadosAtualizacaoMeditoDTO.nome();
    }
    if (dadosAtualizacaoMeditoDTO.telefone() != null) {
      this.telefone = dadosAtualizacaoMeditoDTO.telefone();
    }
    if (dadosAtualizacaoMeditoDTO.endereco() != null) {
      this.endereco.atualizarInformacoes(dadosAtualizacaoMeditoDTO.endereco());
    }
  }
}
