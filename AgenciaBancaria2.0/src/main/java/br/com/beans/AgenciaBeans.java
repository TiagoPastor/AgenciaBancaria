package br.com.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.management.RuntimeOperationsException;

import org.omnifaces.util.Messages;

import br.com.dao.AgenciaDao;
import br.com.filter.AgenciaFilter;
import br.com.model.Agencia;
import br.com.util.FacesUtil;

@ManagedBean
@ViewScoped
public class AgenciaBeans implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Agencia agencia;
	private List<Agencia> listadeAgencia;
	private AgenciaFilter filtro;
	
	public AgenciaBeans(){
		this.agencia = new Agencia();
		this.filtro = new AgenciaFilter();
	}
	
	
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public List<Agencia> getListadeAgencia() {
		return listadeAgencia;
	}
	
	public void setListadeAgencia(List<Agencia> listadeAgencia) {
		this.listadeAgencia = listadeAgencia;
	}
	public AgenciaFilter getFiltro() {
		return filtro;
	}
	
	public void setFiltro(AgenciaFilter filtro) {
		this.filtro = filtro;
	}
	
	public void novo(){
		agencia = new Agencia();
	}
	
	public void salvar(){
		try{
			AgenciaDao agenciaDao = new AgenciaDao();
			agenciaDao.merge(agencia);
			novo();
			Messages.addGlobalInfo("Agência salvar com sucesso");
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar uma agência");
			erro.printStackTrace();
			
		}
	}
	
	public void listar(){
		try{
			AgenciaDao dao = new AgenciaDao();
			listadeAgencia = dao.listar();
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao tentar listar uma agência");
		}
	}
	
	public void pesquisarAgencia(){
		AgenciaDao dao = new AgenciaDao();
		listadeAgencia = dao.filtrarAgencia(filtro);
	}
	
	public void buscarporID(){
	try{
	String valor = FacesUtil.getParam("agenParam");	
	 
	if( valor != null){
	Long codigo = Long.parseLong(valor);
	AgenciaDao dao = new AgenciaDao();
	agencia = dao.buscarPorId(codigo);
	}
		}catch(RuntimeException erro){
		Messages.addGlobalError("Ocorreu um erro ao tentar buscar uma agência");	
		}
	}
	
	public void excluir(ActionEvent evento){	
		try{
			agencia = (Agencia) evento.getComponent().getAttributes().get("agenciaSelecionada");
			AgenciaDao dao = new AgenciaDao();
			dao.excluir(agencia);
			listadeAgencia = dao.listar();
			
			Messages.addGlobalInfo("Agência removida com sucesso");
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Erro ao tentar remover uma agência");
			erro.printStackTrace();
			
		}
	}
	
	

}
