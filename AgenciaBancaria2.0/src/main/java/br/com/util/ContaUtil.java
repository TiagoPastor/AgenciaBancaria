package br.com.util;

import java.util.Random;

public class ContaUtil {
	
		  
		   private Long conta, saques;
		   private double saldo;
		   
		   public Long gerarNumeroConta(){
			   Random numero = new Random();
		        conta = (long) (1+ numero.nextInt(99999));
		       System.out.println("Numero da conta = " + conta);
		       
		       return conta;
		       
		   }
	

		 /*  public void extrato(){
		       System.out.println("\tEXTRATO");
		       System.out.println("Nome: " + this.nome);
		       System.out.println("Número da conta: " + this.conta);
		       System.out.printf("Saldo atual: %.2f\n",this.saldo);
		       System.out.println("Saques realizados hoje: " + this.saques + "\n");

		   }
*/
		   public void sacar(double valor){
		       if(saldo >= valor){
		           saldo -= valor;
		           saques++;
		           System.out.println("Sacado: " + valor);
		           System.out.println("Novo saldo: " + saldo + "\n");
		       } else {
		           System.out.println("Saldo insuficiente. Faça um depósito\n");
		       }
		   }

		   public void depositar(double valor)
		   {
		       saldo += valor;
		       System.out.println("Depositado: " + valor);
		       System.out.println("Novo saldo: " + saldo + "\n");
		   }

		  
		

		}


