package br.com.filter;

import java.io.Serializable;

import br.com.model.Cliente;
import br.com.model.Conta;

public class ContaFilter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String numeroConta;
	private String nomePessoa;
	
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
   public String getNomePessoa() {
	return nomePessoa;
}
   public void setNomePessoa(String nomePessoa) {
	this.nomePessoa = nomePessoa;
}
   
	
	
	

}
