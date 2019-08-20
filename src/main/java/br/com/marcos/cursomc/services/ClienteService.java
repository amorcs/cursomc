package br.com.marcos.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.cursomc.domain.Cidade;
import br.com.marcos.cursomc.domain.Cliente;
import br.com.marcos.cursomc.domain.Endereco;
import br.com.marcos.cursomc.domain.enums.TipoCliente;
import br.com.marcos.cursomc.dto.ClienteDTO;
import br.com.marcos.cursomc.dto.ClienteNewDTO;
import br.com.marcos.cursomc.repositories.ClienteRepository;
import br.com.marcos.cursomc.repositories.EnderecoRepository;
import br.com.marcos.cursomc.services.exceptions.DataIntegrityService;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente buscarPoId(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
			
		return cliente.orElseThrow(() -> new ObjectNotFoundException(id, Cliente.class.getName()));
	}

	public Cliente atualizarCliente(Cliente cliente) {
		Cliente novoCliente = buscarPoId(cliente.getId());
		updateData(novoCliente, cliente);
		return clienteRepository.save(novoCliente);
	}
	
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		cliente = clienteRepository.save(cliente);
		enderecoRepository.saveAll(cliente.getEnderecos());
		return cliente;
	}

	public List<Cliente> buscaTodos() {
		return clienteRepository.findAll();
	}

	public void deletarCliente(Integer id) {
		Cliente cliente = buscarPoId(id);
		if (cliente.getPedidos().isEmpty()) {
			
			
			clienteRepository.deleteById(id);	
		}else {
			throw new DataIntegrityService("não é possível deletar Cliente relacionadosa pedidos");
		}
	}
	
	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
	}
	public Cliente fromDTO(ClienteNewDTO clienteNewDTO) {
		Cliente cliente = new Cliente(null, clienteNewDTO.getNome(), clienteNewDTO.getEmail(), clienteNewDTO.getCpfOuCnpj(), TipoCliente.toEnum(clienteNewDTO.getTipo()));
		
		Cidade cidade = new Cidade(clienteNewDTO.getCidadeId(), null,null);
		Endereco end = new Endereco(null, clienteNewDTO.getLogradouro(), clienteNewDTO.getNumero(), clienteNewDTO.getComplemento(), clienteNewDTO.getBairro(), clienteNewDTO.getCep(), cliente, cidade);
		cliente.getEnderecos().add(end);
		cliente.getTelefones().add(clienteNewDTO.getTelefone1());
		if (clienteNewDTO.getTelefone2()!=null) {
			cliente.getTelefones().add(clienteNewDTO.getTelefone2());
		}
		if (clienteNewDTO.getTelefone3()!=null) {
			cliente.getTelefones().add(clienteNewDTO.getTelefone3());
		}

		return cliente;
	}

	//método auxiliar 
	private void updateData(Cliente novoCliente, Cliente cliente) {
		novoCliente.setNome(cliente.getNome());
		novoCliente.setEmail(cliente.getEmail());
	}

	
	
	



}
