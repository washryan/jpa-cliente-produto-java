package br.com.washryan.dao.jpa;

import br.com.washryan.dao.generic.jpa.GenericJpaDAO;
import br.com.washryan.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
