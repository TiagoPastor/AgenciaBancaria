package br.com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.filter.AgenciaFilter;
import br.com.model.Agencia;
import br.com.util.HibernateUtil;

public class AgenciaDao extends GenericDao<Agencia> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Agencia> filtrarAgencia(AgenciaFilter filtro){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria consulta = sessao.createCriteria(Agencia.class);
		
		try{
			if(StringUtils.isNotBlank(filtro.getEndereco())){
				consulta.add(Restrictions.like("endereco", filtro.getEndereco(), MatchMode.ANYWHERE));
			}
			
			if(StringUtils.isNotBlank(filtro.getNumeroAgencia())){
				consulta.add(Restrictions.eq("numeroAgencia", filtro.getNumeroAgencia()));
			}
			return consulta.addOrder(Order.asc("endereco")).list();	
		}catch(RuntimeException erro){
			throw erro;	
		}finally {
			sessao.close();
		}
	}

}
