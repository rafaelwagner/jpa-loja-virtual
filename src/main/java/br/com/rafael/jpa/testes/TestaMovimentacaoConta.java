package br.com.rafael.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rafael.jpa.modelo.Conta;
import br.com.rafael.jpa.modelo.Movimentacao;

public class TestaMovimentacaoConta {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao mov = em.find(Movimentacao.class, 2L);
		
		Conta conta = mov.getConta();
		int qt = conta.getMovimentacoes().size();
		
		System.out.println("Titular da Conta: " + conta.getTitular());
		System.out.println("Quantidade: " + qt);
		
				
		
	}

}
