package br.com.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dao.ClienteDao;
import br.com.dao.ContaDao;
import br.com.model.Cliente;

public class TesteClienete {

	@Test
	public void salvar(){
		 Cliente cliente = new Cliente();
		cliente.setNome("joão");
		cliente.setCpf("769.321.830-05");
		cliente.setRg("7896541");
		
		ClienteDao dao = new ClienteDao();
		dao.salvar(cliente);
		
		System.out.println(cliente);
	}
	
	@Test
	@Ignore
	public void editar(){
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarPorId(2L);
		cliente.setCpf("258.741.369-22");
		cliente.setRg("5237894");
		dao.editar(cliente);
		System.out.println(cliente);
	}
	
	@Test
	@Ignore
	public void lista(){
		
		ClienteDao dao = new ClienteDao();
		List<Cliente>listar = dao.listar();
		System.out.println(listar);
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarPorId(2L);
		dao.excluir(cliente);
		System.out.println(cliente);
	}
	
	
		
	}

