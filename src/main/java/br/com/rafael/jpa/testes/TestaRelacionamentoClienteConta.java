package br.com.rafael.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rafael.jpa.modelo.Cliente;
import br.com.rafael.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cli = new Cliente();
		cli.setNome("Rafael");
		cli.setEndereco("Rua Pedro João Maria");
		cli.setProfissao("Programador");
		cli.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(cli);
		
		em.getTransaction().commit();
		em.close();
		
	}
}
