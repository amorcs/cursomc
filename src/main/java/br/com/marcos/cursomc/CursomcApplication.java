package br.com.marcos.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.marcos.cursomc.domain.Cidade;
import br.com.marcos.cursomc.domain.Cliente;
import br.com.marcos.cursomc.domain.Endereco;
import br.com.marcos.cursomc.domain.Estado;
import br.com.marcos.cursomc.domain.enums.TipoCliente;
import br.com.marcos.cursomc.repositories.CidadeRepository;
import br.com.marcos.cursomc.repositories.ClienteRepository;
import br.com.marcos.cursomc.repositories.EnderecoRepository;
import br.com.marcos.cursomc.repositories.EstadoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
//	@Autowired
//	private ClienteRepository clienteRepository;
//	
//	@Autowired
//	private EnderecoRepository enderecoRepository;
//	
//	@Autowired
//	private EstadoRepository estadoRepository;
//	
//	@Autowired
//	private CidadeRepository cidadeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Estado est1 = new Estado(null, "Pará");
//		Estado est2 = new Estado(null, "São Paulo");
//
//		Cidade cid1 = new Cidade(null, "Belém", est1);
//		Cidade cid2 = new Cidade(null, "Capanema", est1);
//		Cidade cid3 = new Cidade(null, "São Paulo", est2);
//
//		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
//		est2.getCidades().addAll(Arrays.asList(cid3));
//		
//		estadoRepository.saveAll(Arrays.asList(est1, est2));
//		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
//		
//		Cliente cli1 = new Cliente(null, "marcos"	, "marco.sds@hotmail.com", "898.332.602-68", TipoCliente.PESSOA_FISICA);
//		cli1.getTelefones().addAll(Arrays.asList("(91)98102-5571", "(91)98494-7099"));
//		
//		Endereco e1 = new Endereco(null, "Passagem São raimundo", "123", "1", "Cabangem", "321", cli1, cid1 );
//		Endereco e2 = new Endereco(null, "Bom Jardin", "1223", "pracinha", "Jurunas", "321", cli1, cid1 );
//		
//		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
//		
//		clienteRepository.saveAll(Arrays.asList(cli1));
//		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
