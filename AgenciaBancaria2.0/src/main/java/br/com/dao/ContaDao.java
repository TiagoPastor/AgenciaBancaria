package br.com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.filter.ContaFilter;
import br.com.model.Conta;
import br.com.util.HibernateUtil;

public class ContaDao extends GenericDao<Conta> {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Conta> filtrarContas(ContaFilter filtro){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria consulta = sessao.createCriteria(Conta.class);

		try{
			
			if(StringUtils.isNotBlank(filtro.getNumeroConta())){
				Long numero = Long.parseLong(filtro.getNumeroConta());
				consulta.add(Restrictions.eq("numeroConta",numero));	
			}
			if(StringUtils.isNotBlank(filtro.getNomePessoa())){
	         consulta.createAlias("cliente", "c").add(Restrictions.like("c.nome",filtro.getNomePessoa(),
	        		 MatchMode.ANYWHERE));
			}
			return consulta.list();
		}catch(RuntimeException erro){
		  throw erro;
		  
		}finally {
			sessao.close();
		}
	}

}
/*addOrder(Order.asc("c.nome")).*/