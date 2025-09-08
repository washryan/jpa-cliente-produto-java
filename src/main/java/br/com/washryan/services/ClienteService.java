package br.com.washryan.services;

import br.com.washryan.dao.jpa.IClienteJpaDAO;
import br.com.washryan.domain.jpa.ClienteJpa;
import br.com.washryan.exceptions.DAOException;
import br.com.washryan.exceptions.MaisDeUmRegistroException;
import br.com.washryan.exceptions.TableException;
import br.com.washryan.services.generic.jpa.GenericJpaService;

public class ClienteService extends GenericJpaService<ClienteJpa, Long> implements IClienteService {
	
	private IClienteJpaDAO clienteDAO;
	
	public ClienteService(IClienteJpaDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	public ClienteJpa buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}
}
