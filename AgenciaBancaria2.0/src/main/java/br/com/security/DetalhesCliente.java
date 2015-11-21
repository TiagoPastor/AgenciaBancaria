package br.com.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.dao.ClienteDao;
import br.com.model.Cliente;
import br.com.model.Grupo;

public class DetalhesCliente implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarPorCPF(cpf);
		System.out.println(cliente);
		ClienteLogado user = null;
		
		if(cliente != null){
		user = new ClienteLogado(cliente, getGrupos(cliente));
		}
		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Cliente cliente) {
		List<SimpleGrantedAuthority> grupos = new ArrayList<>();
		
		for(Grupo grupo : cliente.getGrupos()){
			grupos.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		return grupos;
	}

}
