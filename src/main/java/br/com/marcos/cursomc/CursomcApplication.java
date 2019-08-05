package br.com.marcos.cursomc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
//	
//	@Autowired
//	private CategoriaRepository categoriaRepository;
//	
//	@Autowired
//	private ProdutoRepository produtoRepositoty;
	
//	@Override
//	public void run(String... args) throws Exception {
//		Categoria cat1 = new Categoria(null, "Informática");
//		Categoria cat2 = new Categoria(null, "Escritório");
//		
//		Produto p1 = new Produto(null, "Computador", 200.00);
//		Produto p2 = new Produto(null, "Fone de Ouvido", 400.00);
//		Produto p3 = new Produto(null, "FOnte de Alimentação", 300.00);
//		
//		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
//		cat2.getProdutos().addAll(Arrays.asList(p2));
//		
//		p1.getCategorias().addAll(Arrays.asList(cat1));
//		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
//		p3.getCategorias().addAll(Arrays.asList(cat1));
//		
//		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
//		produtoRepositoty.saveAll(Arrays.asList(p1,p2,p3));
//	}

}
