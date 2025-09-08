package br.com.washryan.services;

import br.com.washryan.domain.Cliente;
import br.com.washryan.exceptions.DAOException;
import br.com.washryan.services.generic.IGenericService;

public interface IClienteService extends IGenericJpaService<ClienteJpa, Long> {

	ClienteJpa buscarPorCPF(Long cpf) throws DAOException;
}
