package br.com.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omnifaces.util.Messages;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void login() throws ServletException, IOException{
		RequestDispatcher dispatcher = getHttpServletRequest().getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(getHttpServletRequest(), getHttpServletResponse());
		getFacesContext().responseComplete();
	}
	
	public void render(){
		if("true".equals(getHttpServletRequest().getParameter("invalido"))){
			Messages.addGlobalError("Usuário ou senha inválido!");
		}
	}
	
	
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	
	public ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
	
	
	
	public HttpServletRequest getHttpServletRequest() {
		return ((HttpServletRequest) getExternalContext().getRequest());	
	}
	
	
	public HttpServletResponse getHttpServletResponse() {
		return ((HttpServletResponse) getExternalContext().getResponse());	
	}
	
	
	
	
	

}
