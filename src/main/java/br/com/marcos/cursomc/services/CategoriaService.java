package br.com.marcos.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.cursomc.domain.Categoria;
import br.com.marcos.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorId(Integer id)  {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado " +id, Categoria.class.getName()));
	}

	public Categoria inserirCategoria(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	public Categoria atualizarCategoria(Categoria categoria) {
		buscarPorId(categoria.getId());
		return categoriaRepository.save(categoria);
	}

	public void deletarCategoria(Integer id) {
		Categoria categoria = buscarPorId(id);
			if (categoria.getProdutos().isEmpty()) {
				categoriaRepository.deleteById(id);	
			}else {
				System.out.println("objeto não deletado");
			}
	
	}

	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}
}
