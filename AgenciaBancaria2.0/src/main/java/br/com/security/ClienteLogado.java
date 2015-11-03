package br.com.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.model.Cliente;

public class ClienteLogado extends User{
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	public ClienteLogado(Cliente cliente, Collection<? extends GrantedAuthority> authorities) {
		super(cliente.getCpf(), cliente.getSenha(), authorities);
	     this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	


}
