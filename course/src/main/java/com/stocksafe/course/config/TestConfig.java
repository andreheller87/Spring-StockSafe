package com.stocksafe.course.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.stocksafe.course.entities.Produto;
import com.stocksafe.course.entities.Usuario;
import com.stocksafe.course.entities.enuns.UserNivel;
import com.stocksafe.course.repositories.ProdutoRepository;
import com.stocksafe.course.repositories.UserRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProdutoRepository productRepository;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "André Heller", "123456",UserNivel.CEO );
		Usuario u2 = new Usuario(null, "Scarpa", "123456",UserNivel.GERENTE);

		userRepository.saveAll(Arrays.asList(u1, u2));

		Produto p1 = new Produto();
		p1.setCodLote(1L);
		p1.setNome("Product 1");
		p1.setValor(10.0f);
		p1.setData(sdf.parse("01/01/2024"));
		p1.setValidade(sdf.parse("01/01/2025"));
		p1.setQuantidade(100);
		p1.setObservacao("Observation for Product 1");
		p1.setArmazenamento("Storage for Product 1");

		Produto p2 = new Produto();
		p2.setCodLote(2L);
		p2.setNome("Product 2");
		p2.setValor(15.0f);
		p2.setData(sdf.parse("02/01/2024"));
		p2.setValidade(sdf.parse("02/01/2025"));
		p2.setQuantidade(150);
		p2.setObservacao("Observation for Product 2");
		p2.setArmazenamento("Storage for Product 2");

		Produto p3 = new Produto();
		p3.setCodLote(3L);
		p3.setNome("Product 3");
		p3.setValor(20.0f);
		p3.setData(sdf.parse("03/01/2024"));
		p3.setValidade(sdf.parse("03/01/2025"));
		p3.setQuantidade(200);
		p3.setObservacao("Observation for Product 3");
		p3.setArmazenamento("Storage for Product 3");

		Produto p4 = new Produto();
		p4.setCodLote(4L);
		p4.setNome("Product 4");
		p4.setValor(25.0f);
		p4.setData(sdf.parse("04/01/2024"));
		p4.setValidade(sdf.parse("04/01/2025"));
		p4.setQuantidade(250);
		p4.setObservacao("Observation for Product 4");
		p4.setArmazenamento("Storage for Product 4");

		Produto p5 = new Produto();
		p5.setCodLote(5L);
		p5.setNome("Product 5");
		p5.setValor(30.0f);
		p5.setData(sdf.parse("05/01/2024"));
		p5.setValidade(sdf.parse("05/01/2025"));
		p5.setQuantidade(300);
		p5.setObservacao("Observation for Product 5");
		p5.setArmazenamento("Storage for Product 5");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}

}
