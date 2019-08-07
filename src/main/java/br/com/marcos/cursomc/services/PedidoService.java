package br.com.marcos.cursomc.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.cursomc.domain.Pedido;
import br.com.marcos.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido buscarPoId(Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
			
		return pedido.orElseThrow(() -> new ObjectNotFoundException(id, Pedido.class.getName()));
	}

}
