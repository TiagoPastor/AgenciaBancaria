package br.com.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dao.ClienteDao;
import br.com.dao.ContaDao;
import br.com.model.Cliente;
import br.com.model.Conta;
import br.com.util.ContaUtil;

public class TesteContaDao {
	

	
	/*@Test
	@Ignore
	public void salvar(){
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscarPorId(1L);
		
		Conta conta = new Conta();
		conta.setAgencia(123456);
		conta.setLimite(new BigDecimal(2000.00));
		conta.setNumeroConta(23458);
		conta.setSaldo(new BigDecimal(500.00));
		conta.setSenha(2389);
		conta.setTipoConta(TipoDeConta.POUPANCA);
		conta.setCliente(cliente);
		
		ContaDao dao = new ContaDao();
		dao.salvar(conta);
		
		System.out.println(conta);
	}
	*/
	
	@Test
	
	public void editar(){
		/*ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscarPorId(1L);*/
		ContaDao dao = new ContaDao();
		
		Conta conta = dao.buscarPorId(1L);
		System.out.println(conta);
		//conta.setLimite(new BigDecimal(2000.00));
		conta.setSenha("testettt");
		System.out.println("saldo da conta" + conta.getSaldo());
//		conta.setCliente(cliente);
		
		
		dao.editar(conta);
		
		System.out.println(conta);
	}
	
	@Test
	@Ignore
	public void listando(){
		ContaDao dao = new ContaDao();
		List<Conta> lista = dao.listar();
		System.out.println(lista);
	}
	
	@Test
	@Ignore
	public void excluir(){
		ContaDao dao = new ContaDao();
		Conta conta = dao.buscarPorId(3L);
		dao.excluir(conta);
		System.out.println(conta);
	}
	
	@Test
	@Ignore
	public void pesquisarCliente(){
	    ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarPorId(3L);
	   System.out.println(cliente);
}
	@Test
@Ignore
      public void teste(){
    	  ClienteDao dao = new ClienteDao();
    	  List<Cliente> listar = dao.buscarPorNome("pastor");
    	  System.out.println(listar);
      }
	
	@Test
	@Ignore
	public void gerarnumero(){
		ContaUtil n = new ContaUtil();
		n.gerarNumeroConta();
	}
	
}
