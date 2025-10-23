package model;

import java.util.Date;

public class clienteModel {

	private int id_cliente;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private Date data_cadastro;
	private Date data_alteracao;

	
	public clienteModel(
			int id_cliente, 
			String nome, 
			String cpf, 
			String telefone, 
			String email, 
			Date data_cadastro,
			Date data_alteracao) {
		
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.data_cadastro = data_cadastro;
		this.data_alteracao = data_alteracao;
	}

	
	public clienteModel() {
	}

	public int getIdCliente() {
		return id_cliente;
	}

	public void setIdCliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return data_cadastro;
	}

	public void setDataCadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Date getDataAlteracao() {
		return data_alteracao;
	}

	public void setDataAlteracao(Date data_alteracao) {
		this.data_alteracao = data_alteracao;
	}
}
