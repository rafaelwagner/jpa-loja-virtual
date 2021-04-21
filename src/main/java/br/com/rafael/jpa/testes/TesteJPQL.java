package br.com.rafael.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.rafael.jpa.modelo.Conta;
import br.com.rafael.jpa.modelo.Movimentacao;



public class TesteJPQL {
	
	public static void main(String[] args) {
		
		String jpql = "select m from Movimentacao m where m.conta = :pconta order by m.valor desc";
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

	    TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
	    query.setParameter("pconta", conta);
	    
	    List<Movimentacao> resultList = query.getResultList();
	    
	    for (Movimentacao movimentacao : resultList) {
	    	System.out.println("Descrição" + movimentacao.getDescricao());
	    	System.out.println("Tipo" + movimentacao.getTipoMovimentacao());
	    }
		em.close();
		
	}

}
