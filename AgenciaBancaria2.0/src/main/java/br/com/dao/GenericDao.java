package br.com.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.filter.ClienteFilter;
import br.com.util.HibernateUtil;



public class GenericDao<Entidade> {
	
	@SuppressWarnings("unused")
	private Class<Entidade> classe;
	
	
	@SuppressWarnings("unchecked")
	public GenericDao(){
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		}catch(RuntimeException erro){
			if(transacao != null){
				transacao.rollback();
			}
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(classe);
		//	List<Entidade> resultado = consulta.list();
			return consulta.addOrder(Order.asc("nome")).list();
		}catch(RuntimeException erro){
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> filtrados(ClienteFilter filtro){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria consulta = sessao.createCriteria(classe);
		try{
			//o isNotBlacnk verfica se tem espaço em branco, vazio ou nulo
			if(StringUtils.isNotBlank(filtro.getCpf())){
				consulta.add(Restrictions.eq("cpf", filtro.getCpf()));
			}
			
			//MatchMode.ANYWHERE O 	nome fica em qual quer lugar 
			if(StringUtils.isNotBlank(filtro.getNome())){
				consulta.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			//ordena ascendente pelo nome
			return consulta.addOrder(Order.asc("nome")).list();
		}catch(RuntimeException erro){
			throw erro;
		}finally {
			sessao.close();
		}
	}
	                           
	
	@SuppressWarnings("unchecked")
	public Entidade buscarPorId(Long id){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try{
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(id));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		}catch(RuntimeException erro){
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	public void excluir(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		}catch(RuntimeException erro){
		if (transacao != null){
			transacao.rollback();
		}
		throw erro;
		
		}finally {
			sessao.close();
		}
	}
	
	public void editar(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		}catch(RuntimeException erro){
			if(transacao != null){
				transacao.rollback();
			}
			throw erro;
		}finally {
			sessao.close();
		}
	}
	

	public void merge(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		}catch(RuntimeException erro){
			if(transacao != null){
				transacao.rollback();
			}
			throw erro;
		}finally {
			sessao.close();
		}
	}
	
	

}
