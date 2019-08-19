package br.com.marcos.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.cursomc.domain.Cliente;
import br.com.marcos.cursomc.dto.ClienteDTO;
import br.com.marcos.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> buscaPorId(@PathVariable("id") Integer id){
		Cliente cliente = clienteService.buscarPoId(id);
		return ResponseEntity.ok().body(cliente);
	}
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> listaClientes(){
		List<Cliente> clientes = clienteService.buscaTodos();
		List<ClienteDTO> clientesDTO = clientes.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
		return ResponseEntity.ok().body(clientesDTO);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizarCliente(@PathVariable("id") Integer id, @Valid @RequestBody ClienteDTO clienteDTO){
		Cliente cliente = clienteService.fromDTO(clienteDTO);
		cliente.setId(id);
		cliente = clienteService.atualizarCliente(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable("id")Integer id){
		clienteService.deletarCliente(id);
		return ResponseEntity.ok().build();
		
	}
}
