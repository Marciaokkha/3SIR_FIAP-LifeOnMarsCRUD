package br.fiap.app.mars.models;

import br.fiap.app.mars.validators.MultiploDeTres;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Viagem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	@NotBlank(message = "A data de decolagem deve ser fornecida")
	@Pattern(regexp="^\\d{2}/\\d{2}/\\d{4}$", message="A data deve estar no formato dd/MM/yyyy")
	private String dataDecolagem;
	
	@NotBlank(message = "O tempo de estadia deve ser preenchido")
	@Pattern(regexp="^\\d+$", message="O tempo de estadia está inválido, é esperado um número inteiro positivo")
	private String diasEstadia;
	
	private String dataRetorno;
	
	//Aqui tentei fazer a validação se uma até então String era múltipla de 3, o resultado não foi satisfatório
	//Dessa forma criei um validador @MultiploDeTres dentro do pacote validators, para realizarmos essa ação.
	@MultiploDeTres
	private Integer qtdAssentos;
	
	@NotBlank(message = "O modelo da nave deve ser fornecido")
	@Pattern(regexp="^[a-zA-Z]{4}-\\d{4}$", message="Modelo de nave inválido, é esperado o formato aaaa-9999, "
					+ "onde a são letras de a-z, e 9 representa os números de 0 a 9")
	private String modeloNave;
	
	@NotBlank(message = "O nome do primeiro comandante deve ser fornecido")
	@Pattern(regexp=".*", message="O nome do primeiro comandante está inválido, "
			+ "é esperado que o nome contenha apenas letras")
	private String nomePrimeiroComandante;
	
	@NotBlank(message = "A matrícula do primeiro comandante deve ser fornecida")
	@Pattern(regexp="^[A-Z]{3}-\\d{4}-[A-Z]\\d[A-Z]$", message="A matrícula do primeiro comandante está inválida, "
			+ "a matrícula deve estar no formato XXX-9999-X9X")
	private String matriculaPrimeiroComandante;
	
	@NotBlank(message = "O nome do segundo comandante deve ser fornecido")
	@Pattern(regexp=".*", message="O nome do segundo comandante está inválido, "
			+ "é esperado que o nome contenha apenas letras")
	private String nomeSegundoComandante;
	
	@NotBlank(message = "A matrícula do segundo comandante deve ser fornecida")
	@Pattern(regexp="^[A-Z]{3}-\\d{4}-[A-Z]\\d[A-Z]$", message="A matrícula do segundo comandante está inválida, "
			+ "a matrícula deve estar no formato XXX-9999-X9X")
	private String matriculaSegundoComandante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(String dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public String getDiasEstadia() {
		return diasEstadia;
	}

	public void setDiasEstadia(String diasEstadia) {
		this.diasEstadia = diasEstadia;
	}

	public String getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(String dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Integer getQtdAssentos() {
		return qtdAssentos;
	}

	public void setQtdAssentos(Integer qtdAssentos) {
		this.qtdAssentos = qtdAssentos;
	}

	public String getModeloNave() {
		return modeloNave;
	}

	public void setModeloNave(String modeloNave) {
		this.modeloNave = modeloNave;
	}

	public String getNomePrimeiroComandante() {
		return nomePrimeiroComandante;
	}

	public void setNomePrimeiroComandante(String nomePrimeiroComandante) {
		this.nomePrimeiroComandante = nomePrimeiroComandante;
	}

	public String getMatriculaPrimeiroComandante() {
		return matriculaPrimeiroComandante;
	}

	public void setMatriculaPrimeiroComandante(String matriculaPrimeiroComandante) {
		this.matriculaPrimeiroComandante = matriculaPrimeiroComandante;
	}

	public String getNomeSegundoComandante() {
		return nomeSegundoComandante;
	}

	public void setNomeSegundoComandante(String nomeSegundoComandante) {
		this.nomeSegundoComandante = nomeSegundoComandante;
	}

	public String getMatriculaSegundoComandante() {
		return matriculaSegundoComandante;
	}

	public void setMatriculaSegundoComandante(String matriculaSegundoComandante) {
		this.matriculaSegundoComandante = matriculaSegundoComandante;
	}
	
}
