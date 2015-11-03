package br.com.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.dao.AgenciaDao;
import br.com.dao.ClienteDao;
import br.com.dao.ContaDao;
import br.com.filter.ClienteFilter;
import br.com.filter.ContaFilter;
import br.com.model.Agencia;
import br.com.model.Cliente;
import br.com.model.Conta;
import br.com.model.TipoDeConta;
import br.com.util.ContaUtil;
import br.com.util.FacesUtil;

@ManagedBean
@ViewScoped

public class ContaBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	private Conta conta;
	private List<Cliente> listarClientes;
	private List<Conta>listarContas;
	private List<Agencia> listarAgencia;
	private ClienteFilter filtroCliente;
	private ContaFilter contafilter;
	private Cliente cliente;
	private Agencia agencia;
	
	private String acao;
	
	public ContaBeans() {
		this.conta = new Conta();
		this.filtroCliente = new ClienteFilter();
		this.cliente = new Cliente();
	    this.agencia = new Agencia();
	    this.contafilter = new ContaFilter();
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
	
	public ContaFilter getContafilter() {
		return contafilter;
	}
	
	public void setContafilter(ContaFilter contafilter) {
		this.contafilter = contafilter;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
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
			ContaUtil util = new ContaUtil();
			ContaDao dao = new ContaDao();
			this.conta.setNumeroConta(util.gerarNumeroConta());
		   dao.merge(this.conta);
			Messages.addGlobalInfo("Conta criada com sucesso");
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao tentar criar uma conta ");
			erro.printStackTrace();
		}
	}
	
	public void pesquisar(){
		ContaDao dao = new ContaDao();
		listarContas = dao.filtrarContas(contafilter);
	}
	
	public void carregarCadastro(){
		try{
		 String valor = FacesUtil.getParam("contcod");
		 
		 if(valor != null){
			 Long codigo = Long.parseLong(valor);
			 ContaDao dao = new ContaDao();
			 conta = dao.buscarPorId(codigo);
		 }
			
		}catch(RuntimeException erro){
		Messages.addGlobalError("Ocorreu um erro ao tentar buscar uma ");
		erro.printStackTrace();
			
		}
	}
	
	public void editar(){
		try{
			ContaDao dao = new ContaDao();
			dao.editar(this.conta);
			Messages.addGlobalInfo("Conta atualizada com sucesso");
		}catch(RuntimeException erro){
			Messages.addGlobalError("Não foi possível atualizar a conta ");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		try{
			conta = (Conta) evento.getComponent().getAttributes().get("contaSelecionado");
			ContaDao dao = new ContaDao();
			dao.excluir(this.conta);
			Messages.addGlobalInfo("Conta excluida com sucesso");
			listarContas = dao.listar();
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao tentar excluir a conta");
			erro.printStackTrace();
			
		}
	}
	
	public void depositar(){
		try{

			ContaDao contaDao = new ContaDao();
			//conta = contaDao.buscarPorId(3L);
		System.out.println(conta);
		conta.setSenha("1235ACDG");
		//conta.setSaldo(new BigDecimal(5000));
		contaDao.editar(this.conta);
		Messages.addGlobalInfo("Deposito feito com sucesso");
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao tentar excluir a conta");
			erro.printStackTrace();
		}
		
	}
	
	public void teste(){
		ContaDao dao = new ContaDao();
		conta = dao.buscarPorId(8L);
	}
}
