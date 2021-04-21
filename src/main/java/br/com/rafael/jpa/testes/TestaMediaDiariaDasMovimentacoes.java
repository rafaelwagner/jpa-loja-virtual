package br.com.rafael.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rafael.jpa.modelo.MediaComData;
import br.com.rafael.jpa.modelo.dao.MovimentacaoDao;

public class TestaMediaDiariaDasMovimentacoes {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao(em).getMediaDiariaDasMovimentacoes();

		for (MediaComData resultado : mediaDasMovimentacoes) {
			System.out.println("A m�dia das movimentacoes do dia " + resultado.getDia() + "/" + resultado.getMes()
					+ " �: " + resultado.getValor());
		}
	}
}
