package br.com.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message = "Ocampo senha é obrigatorio")
	@Size(message = "A senha deve ter no mínimo 6 e máximo 32 caracteres", max = 32, min= 6)
	private String senha;
	private Long numeroConta;
	@Digits(integer=4, fraction=2, message= "O limite máximo do valor da conta é de R$ 9.999,99 ")
	private BigDecimal saldo;
	@Digits(integer=4, fraction=2, message= "O limite máximo do valor da conta é de R$ 9.999,99 ")
	@DecimalMin("500.00")
	private BigDecimal limite;
	@Enumerated(EnumType.STRING)
	private TipoDeConta tipoConta;
	@ManyToOne
	private Agencia agencia;
	
	@OneToOne
		private Cliente cliente;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(Long numeroConta) {
		this.numeroConta = numeroConta;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public BigDecimal getLimite() {
		return limite;
	}
	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public TipoDeConta getTipoConta() {
		return tipoConta;
	}
	
	public void setTipoConta(TipoDeConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public Agencia getAgencia() {
		return agencia;
	}
	
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Conta [id=" + id + ", agencia=" + agencia + ", senha=" + senha + ", numeroConta=" + numeroConta
				+ ", saldo=" + saldo + ", limite=" + limite + "]";
	}
	
	
	

}
