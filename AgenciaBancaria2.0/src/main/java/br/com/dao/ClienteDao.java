package br.com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.filter.ClienteFilter;
import br.com.model.Cliente;
import br.com.util.HibernateUtil;

public class ClienteDao extends GenericDao<Cliente> {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarPorNome(String nome){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

			Criteria consulta = sessao.createCriteria(Cliente.class);
			if(StringUtils.isNotBlank(nome)){
			consulta.add(Restrictions.ilike("nome", nome.toUpperCase(),MatchMode.ANYWHERE));
			return consulta.list() ;
			}
			sessao.close();
			return null;
		}
	}   


