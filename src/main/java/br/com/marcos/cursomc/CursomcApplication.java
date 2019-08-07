package br.com.marcos.cursomc;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.marcos.cursomc.domain.Cidade;
import br.com.marcos.cursomc.domain.Cliente;
import br.com.marcos.cursomc.domain.Endereco;
import br.com.marcos.cursomc.domain.Estado;
import br.com.marcos.cursomc.domain.Pagamento;
import br.com.marcos.cursomc.domain.PagamentoComBoleto;
import br.com.marcos.cursomc.domain.PagamentoComCartao;
import br.com.marcos.cursomc.domain.Pedido;
import br.com.marcos.cursomc.domain.enums.EstadoPagamento;
import br.com.marcos.cursomc.domain.enums.TipoCliente;
import br.com.marcos.cursomc.repositories.CidadeRepository;
import br.com.marcos.cursomc.repositories.ClienteRepository;
import br.com.marcos.cursomc.repositories.EnderecoRepository;
import br.com.marcos.cursomc.repositories.EstadoRepository;
import br.com.marcos.cursomc.repositories.PagamentoRepository;
import br.com.marcos.cursomc.repositories.PedidoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Estado est1 = new Estado(null, "Pará");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Belém", est1);
		Cidade cid2 = new Cidade(null, "Capanema", est1);
		Cidade cid3 = new Cidade(null, "São Paulo", est2);

		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "marcos"	, "marco.sds@hotmail.com", "898.332.602-68", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("(91)98102-5571", "(91)98494-7099"));
		
		Endereco e1 = new Endereco(null, "Passagem São raimundo", "123", "1", "Cabangem", "321", cli1, cid1 );
		Endereco e2 = new Endereco(null, "Bom Jardin", "1223", "pracinha", "Jurunas", "321", cli1, cid1 );
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido pedido1 = new Pedido(null, sdf.parse("06/08/2019 09:00"), cli1, e1);
		Pedido pedido2 = new Pedido(null, sdf.parse("07/08/2019 09:00"), cli1, e2);	
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 12);
		pedido1.setPagamento(pag1);
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("08/08/2019 00:00"), null);
		pedido2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));
	}

}
