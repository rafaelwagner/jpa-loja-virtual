package br.com.rafael.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.rafael.jpa.modelo.Categoria;
import br.com.rafael.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoCategoria {
	public static void main(String[] args) {

		String jpql = "select m from Movimentacao m join m.categoria c where c = :pcategoria order by m.valor desc";

		Categoria categoria = new Categoria();
		categoria.setId(3L);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pcategoria", categoria);

		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição" + movimentacao.getDescricao());
			System.out.println("Tipo" + movimentacao.getTipoMovimentacao());
		}
		em.close();

	}
}
