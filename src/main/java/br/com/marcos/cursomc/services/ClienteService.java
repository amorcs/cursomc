package br.com.marcos.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.cursomc.domain.Cliente;
import br.com.marcos.cursomc.dto.ClienteDTO;
import br.com.marcos.cursomc.repositories.ClienteRepository;
import br.com.marcos.cursomc.services.exceptions.DataIntegrityService;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarPoId(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
			
		return cliente.orElseThrow(() -> new ObjectNotFoundException(id, Cliente.class.getName()));
	}

	public Cliente atualizarCliente(Cliente cliente) {
		Cliente novoCliente = buscarPoId(cliente.getId());
		updateData(novoCliente, cliente);
		
		return clienteRepository.save(novoCliente);
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

	//método auxiliar 
	private void updateData(Cliente novoCliente, Cliente cliente) {
		novoCliente.setNome(cliente.getNome());
		novoCliente.setEmail(cliente.getEmail());
	}



}
