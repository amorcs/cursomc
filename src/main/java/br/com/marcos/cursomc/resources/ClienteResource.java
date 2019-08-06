package br.com.marcos.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.cursomc.domain.Cliente;
import br.com.marcos.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Integer id){
		Cliente cliente = clienteService.buscarPoId(id);
		return ResponseEntity.ok().body(cliente);
		
	}
}
