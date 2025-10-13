package med.voll.api_voll_med.model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api_voll_med.model.dto.endereco.EnderecoDTO;

@Embeddable // como Medico o Endereco é Embedded aqui eu tenho que falar que é possível fazer um embed deve "Embeddable"
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
  private String logradouro;
  private String bairro;
  private String cep;
  private String numero;
  private String complemento;
  private String cidade;
  private String uf;

  public Endereco(EnderecoDTO enderecoDTO) {
    this.logradouro = enderecoDTO.getLogradouro();
    this.bairro = enderecoDTO.getBairro();
    this.cep = enderecoDTO.getCep();
    this.numero = enderecoDTO.getNumero();
    this.complemento = enderecoDTO.getComplemento();
    this.cidade = enderecoDTO.getCidade();
    this.uf = enderecoDTO.getUf();
  }

  public void atualizarInformacoes(EnderecoDTO endereco) {
    if (endereco.getLogradouro() != null) {
      this.logradouro = endereco.getLogradouro();
    }
    if (endereco.getBairro() != null) {
      this.bairro = endereco.getBairro();
    }
    if (endereco.getCep() != null) {
      this.cep = endereco.getCep();
    }
    if (endereco.getCidade() != null) {
      this.cidade = endereco.getCidade();
    }
    if (endereco.getUf() != null) {
      this.uf = endereco.getUf();
    }
    this.bairro = endereco.getBairro();
    this.cep = endereco.getCep();
    this.cidade = endereco.getCidade();
    this.uf = endereco.getUf();

    this.numero = endereco.getNumero();
    this.complemento = endereco.getComplemento();
  }
}
