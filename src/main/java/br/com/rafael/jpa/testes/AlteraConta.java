package br.com.rafael.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rafael.jpa.modelo.Conta;

public class AlteraConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta contaRafael = em.find(Conta.class, 1L);
		contaRafael.setSaldo(10000.0);

		em.getTransaction().begin();

		em.persist(contaRafael);

		em.getTransaction().commit();

		emf.close();
	}

}
