package br.com.washryan.services;

import br.com.washryan.dao.IProdutoDAO;
import br.com.washryan.domain.Produto;
import br.com.washryan.exceptions.TipoChaveNaoEncontradaException;
import br.com.washryan.services.generic.GenericService;

public interface IVendaService extends IGenericJpaService<VendaJpa, Long> {
	
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public VendaJpa consultarComCollection(Long id);
}
