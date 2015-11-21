package br.com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.security.ClienteLogado;

@ManagedBean
@RequestScoped
public class UsuarioLogado {
	
	public String getNomeUsuario(){
		String nome = null;
		ClienteLogado logado = getClienteSistema();
		
		if(logado != null){
			nome = logado.getCliente().getNome();
		}
		
		return nome;
	}

	private ClienteLogado getClienteSistema() {
	   ClienteLogado logado = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)
		FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		 if (auth != null && auth.getPrincipal() != null){
			logado = (ClienteLogado) auth.getPrincipal(); 
		 }
		
		
		return logado;
	}
	
	
	

}
