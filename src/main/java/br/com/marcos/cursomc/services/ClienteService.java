package br.com.marcos.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.cursomc.domain.Cliente;
import br.com.marcos.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarPoId(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
			
		return cliente.orElseThrow(() -> new ObjectNotFoundException(id, Cliente.class.getName()));
	}

}
