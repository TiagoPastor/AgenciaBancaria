package br.com.filter;

import java.io.Serializable;

public class AgenciaFilter implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String endereco;
	private String numeroAgencia;
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
	

}
