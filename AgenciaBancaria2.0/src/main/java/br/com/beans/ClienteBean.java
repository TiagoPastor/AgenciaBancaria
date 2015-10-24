package br.com.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.dao.ClienteDao;
import br.com.filter.ClienteFilter;
import br.com.model.Cliente;
import br.com.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private List<Cliente> clientes;
	private ClienteFilter filtro;
	
	public ClienteBean() {
		
		this.cliente = new Cliente();
		this.filtro = new ClienteFilter();
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public ClienteFilter getFiltro() {
		return filtro;
	}
	
	public void setFiltro(ClienteFilter filtro) {
		this.filtro = filtro;
	}
	
	public void novo(){
		cliente = new Cliente();
	}
	
	public void salvar(){
		try{
			ClienteDao dao = new ClienteDao();
			dao.merge(cliente);
			  novo();
		    Messages.addGlobalInfo("Cliente salva com sucesso");
		  
		}catch(RuntimeException erro){
			Messages.addGlobalError("OCorreu um erro ao tentar salvar o cliente");
			erro.printStackTrace();
		}
	}
	
	//@PostConstruct
	public void listar(){
		try{
			ClienteDao dao = new ClienteDao();
			clientes = dao.listar();
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listra os clientes");
			erro.printStackTrace();
		}
	}
	
	public void pesquisar(){
		ClienteDao dao = new ClienteDao();
	 clientes = dao.filtrados(filtro);
	}
	
	public void excluir(ActionEvent evento){
		try{
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			
			ClienteDao dao = new ClienteDao();
			dao.excluir(cliente);
			
			clientes = dao.listar();
			
			Messages.addGlobalInfo("Cliente removido com sucesso");
			
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o cliente");
			erro.printStackTrace();
			
		}
	}
	//@PostConstruct
	public void carregarCadastro(){
		try{
		 String valor = FacesUtil.getParam("funAcao");
		 
		 if(valor != null){
			 Long codigo = Long.parseLong(valor);
			 ClienteDao dao = new ClienteDao();
			cliente = dao.buscarPorId(codigo);
		 }
	}catch(RuntimeException erro){
		Messages.addGlobalError("Ocorreu um erro ao tentar buscar o cliente");
		erro.printStackTrace();
	}
		
	}
	
	

}
