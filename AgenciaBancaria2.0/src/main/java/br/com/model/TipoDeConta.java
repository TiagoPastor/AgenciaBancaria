package br.com.model;

public enum TipoDeConta {
	
	CORRENT("Corrente"),
	POUPANCA("poupança");
	
	private String descricao;
	
	private TipoDeConta(String descricao) {
		this.descricao = descricao;
		
	}

	public String getDescricao() {
		return descricao;
	}

}
