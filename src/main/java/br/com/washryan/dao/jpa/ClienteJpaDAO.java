package br.com.washryan.dao.jpa;

import br.com.washryan.dao.generic.jpa.GenericJpaDAO;
import br.com.washryan.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
