package br.com.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.dao.AgenciaDao;
import br.com.dao.ClienteDao;
import br.com.dao.ContaDao;
import br.com.filter.ClienteFilter;
import br.com.model.Agencia;
import br.com.model.Cliente;
import br.com.model.Conta;
import br.com.model.TipoDeConta;

@ManagedBean
@ViewScoped
public class ContaBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	private Conta conta;
	private List<Cliente> listarClientes;
	private List<Conta>listarContas;
	private List<Agencia> listarAgencia;
	private ClienteFilter filtroCliente;
	private Cliente cliente;
	private Agencia agencia;
	
	public ContaBeans() {
		this.conta = new Conta();
		this.filtroCliente = new ClienteFilter();
		this.cliente = new Cliente();
	    this.agencia = new Agencia();
	}
	 public List<Cliente> getListarClientes() {
		return listarClientes;
	}
	 
	 public void setListarClientes(List<Cliente> listarClientes) {
		this.listarClientes = listarClientes;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public List<Conta> getListarContas() {
		return listarContas;
	}
	public void setListarContas(List<Conta> listarContas) {
		this.listarContas = listarContas;
	}
	
	public ClienteFilter getFiltroCliente() {
		return filtroCliente;
	}
	
	public void setFiltro(ClienteFilter filtroCliente) {
		this.filtroCliente = filtroCliente;
	}
	
	public Agencia getAgencia() {
		return agencia;
	}
	
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public List<Agencia> getListarAgencia() {
		return listarAgencia;
	}
	
	public void setListarAgencia(List<Agencia> listarAgencia) {
		this.listarAgencia = listarAgencia;
	}
	

	public void inicializar(){
		AgenciaDao dao = new AgenciaDao();
	    listarAgencia = dao.listar();
	}
	
	public TipoDeConta[] getTipoConta(){
		return TipoDeConta.values();
	}
	
	public List<Cliente>pesquisarCliente(String nome){
		ClienteDao dao = new ClienteDao();
		return dao.buscarPorNome(nome);
		
	}
	
	public void salvar(){
		try{
			ContaDao dao = new ContaDao();
		   dao.salvar(this.conta);
			Messages.addGlobalInfo("Conta criada com sucesso");
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao tentar criar uma conta ");
			erro.printStackTrace();
		}
	}
	
	

   
}
