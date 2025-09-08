package br.com.washryan;

import java.math.BigDecimal;
import java.time.Instant;

import br.com.washryan.dao.jpa.ClienteJpaDAO;
import br.com.washryan.dao.jpa.ProdutoJpaDAO;
import br.com.washryan.dao.jpa.VendaJpaDAO;
import br.com.washryan.domain.jpa.ClienteJpa;
import br.com.washryan.domain.jpa.ProdutoJpa;
import br.com.washryan.domain.jpa.VendaJpa;
import br.com.washryan.exceptions.DAOException;
import br.com.washryan.exceptions.TipoChaveNaoEncontradaException;
import br.com.washryan.services.IClienteService;
import br.com.washryan.services.IProdutoService;
import br.com.washryan.services.IVendaService;
import br.com.washryan.services.ClienteService;
import br.com.washryan.services.ProdutoService;
import br.com.washryan.services.VendaService;

public class ExemploUsoJPA {
	
	public static void main(String[] args) {
		// Inicializar DAOs
		ClienteJpaDAO clienteDAO = new ClienteJpaDAO();
		ProdutoJpaDAO produtoDAO = new ProdutoJpaDAO();
		VendaJpaDAO vendaDAO = new VendaJpaDAO();
		
		// Inicializar Services
		IClienteService clienteService = new ClienteService(clienteDAO);
		IProdutoService produtoService = new ProdutoService(produtoDAO);
		IVendaService vendaService = new VendaService(vendaDAO);
		
		try {
			// Cadastrar Cliente
			ClienteJpa cliente = new ClienteJpa();
			cliente.setCpf(12345678901L);
			cliente.setNome("João Silva");
			cliente.setTel(11999999999L);
			cliente.setEnd("Rua das Flores, 123");
			cliente.setNumero(123);
			cliente.setCidade("São Paulo");
			cliente.setEstado("SP");
			
			cliente = clienteService.cadastrar(cliente);
			System.out.println("Cliente cadastrado: " + cliente.getNome());
			
			// Cadastrar Produto
			ProdutoJpa produto = new ProdutoJpa();
			produto.setCodigo("PROD001");
			produto.setNome("Notebook Dell");
			produto.setDescricao("Notebook Dell Inspiron 15");
			produto.setValor(new BigDecimal("2500.00"));
			
			produto = produtoService.cadastrar(produto);
			System.out.println("Produto cadastrado: " + produto.getNome());
			
			// Criar Venda
			VendaJpa venda = new VendaJpa();
			venda.setCodigo("VENDA001");
			venda.setCliente(cliente);
			venda.setDataVenda(Instant.now());
			venda.setStatus(VendaJpa.Status.INICIADA);
			venda.adicionarProduto(produto, 2);
			
			venda = vendaService.cadastrar(venda);
			System.out.println("Venda criada: " + venda.getCodigo() + " - Valor: " + venda.getValorTotal());
			
			// Finalizar Venda
			vendaService.finalizarVenda(venda);
			System.out.println("Venda finalizada com sucesso!");
			
		} catch (TipoChaveNaoEncontradaException | DAOException e) {
			e.printStackTrace();
		}
	}
}
