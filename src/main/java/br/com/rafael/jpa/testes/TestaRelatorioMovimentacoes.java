package br.com.rafael.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.rafael.jpa.modelo.Conta;

public class TestaRelatorioMovimentacoes {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select c from Conta c left join fetch c.movimentacoes";
		TypedQuery<Conta> qy = em.createQuery(jpql, Conta.class);
		
		List<Conta> contas = qy.getResultList();
		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes: " + conta.getMovimentacoes());
		}
	}

}
