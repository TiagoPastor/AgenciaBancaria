package br.com.util;

import java.util.Random;

import org.junit.Test;

public class GerarNumeroConta {
	
  // public static void main(String[] args){
	@Test
	public void teste(){
     
      // double inicial;
  
       Random numero = new Random();
       int conta = 1 + numero.nextInt(99999);
       System.out.println("Numero da conta = " + conta);
       
      /* //Criando a conta de um cliente
       ContaUtil minhaConta = new ContaUtil(nome, conta, inicial);
       minhaConta.iniciar();*/
   }


}
	


