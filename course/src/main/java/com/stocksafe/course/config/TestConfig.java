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
		
	/*
		Usuario u1 = new Usuario(null, "André Heller", "123456",UserNivel.CEO );
		Usuario u2 = new Usuario(null, "Scarpa", "123456",UserNivel.GERENTE);

		userRepository.saveAll(Arrays.asList(u1, u2));

		Produto p1 = new Produto();
		p1.setValor(5.99f);
		p1.setObservacao("conjunto com 6x80g");
		p1.setValidade(sdf.parse("20/05/2024"));
		p1.setArmazenamento("F101");
		p1.setCodLote(1001L);
		p1.setData(sdf.parse("05/10/2023"));
		p1.setNome("Leite Fermentado Bob-Esponja 6un80g");
		p1.setId(151565589L);
		p1.setQuantidade(24);

		Produto p2 = new Produto();
		p2.setValor(15.5f);
		p2.setObservacao("embalagem de 500g");
		p2.setValidade(sdf.parse("15/12/2024"));
		p2.setArmazenamento("F102");
		p2.setCodLote(1002L);
		p2.setData(sdf.parse("10/08/2024"));
		p2.setNome("Arroz Integral Tio João 500g");
		p2.setId(151578934L);
		p2.setQuantidade(14);

		Produto p3 = new Produto();
		p3.setValor(9.75f);
		p3.setObservacao("sabor chocolate");
		p3.setValidade(sdf.parse("30/11/2024"));
		p3.setArmazenamento("F103");
		p3.setCodLote(1003L);
		p3.setData(sdf.parse("22/07/2024"));
		p3.setNome("Biscoito Recheado Negresco 150g");
		p3.setId(151589762L);
		p3.setQuantidade(21);

		// Continue criando os próximos produtos conforme necessário...

		Produto p4 = new Produto();
		p4.setValor(30.0f);
		p4.setObservacao("fresco");
		p4.setValidade(sdf.parse("10/10/2024"));
		p4.setArmazenamento("F104");
		p4.setCodLote(1004L);
		p4.setData(sdf.parse("03/09/2023"));
		p4.setNome("Queijo Mussarela Fazenda Feliz 1kg");
		p4.setId(151598473L);
		p4.setQuantidade(12);

		Produto p5 = new Produto();
		p5.setValor(8.99f);
		p5.setObservacao("pacote com 12 unidades");
		p5.setValidade(sdf.parse("05/07/2024"));
		p5.setArmazenamento("F105");
		p5.setCodLote(1005L);
		p5.setData(sdf.parse("18/12/2023"));
		p5.setNome("Salsicha Frankfurt Sadia 500g");
		p5.setId(151607821L);
		p5.setQuantidade(16);

		// Continue criando os próximos produtos conforme necessário...

		Produto p6 = new Produto();
		p6.setValor(14.5f);
		p6.setObservacao("embalagem com 1kg");
		p6.setValidade(sdf.parse("28/11/2024"));
		p6.setArmazenamento("F134");
		p6.setCodLote(1034L);
		p6.setData(sdf.parse("11/05/2024"));
		p6.setNome("Macarrão Espaguete Renata");
		p6.setId(152965874L);
		p6.setQuantidade(22);


		Produto p7 = new Produto();
		p7.setValor(6.75f);
		p7.setObservacao("caixa com 24 unidades");
		p7.setValidade(sdf.parse("05/09/2024"));
		p7.setArmazenamento("F135");
		p7.setCodLote(1035L);
		p7.setData(sdf.parse("18/02/2024"));
		p7.setNome("Bolacha Recheada Oreo 180g");
		p7.setId(151798623L);
		p7.setQuantidade(30);

		Produto p8 = new Produto();
		p8.setValor(25.99f);
		p8.setObservacao("fardo com 12 unidades");
		p8.setValidade(sdf.parse("15/10/2024"));
		p8.setArmazenamento("F136");
		p8.setCodLote(1036L);
		p8.setData(sdf.parse("02/05/2024"));
		p8.setNome("Refrigerante Coca-Cola 2L");
		p8.setId(151875432L);
		p8.setQuantidade(20);

		Produto p9 = new Produto();
		p9.setValor(3.49f);
		p9.setObservacao("caixa com 10 unidades");
		p9.setValidade(sdf.parse("10/07/2024"));
		p9.setArmazenamento("F137");
		p9.setCodLote(1037L);
		p9.setData(sdf.parse("21/12/2023"));
		p9.setNome("Chocolate Ao Leite Nestlé 90g");
		p9.setId(151985623L);
		p9.setQuantidade(40);

		// Continue criando os próximos produtos conforme necessário...

		Produto p49 = new Produto();
		p49.setValor(9.99f);
		p49.setObservacao("embalagem com 400g");
		p49.setValidade(sdf.parse("20/09/2024"));
		p49.setArmazenamento("F149");
		p49.setCodLote(1049L);
		p49.setData(sdf.parse("10/04/2024"));
		p49.setNome("Margarina Qualy 500g");
		p49.setId(152354682L);
		p49.setQuantidade(18);

		Produto p50 = new Produto();
		p50.setValor(7.25f);
		p50.setObservacao("fardo com 12 unidades");
		p50.setValidade(sdf.parse("28/08/2024"));
		p50.setArmazenamento("F150");
		p50.setCodLote(1050L);
		p50.setData(sdf.parse("15/01/2024"));
		p50.setNome("Cerveja Skol 350ml");
		p50.setId(152457896L);
		p50.setQuantidade(25);

		Produto p51 = new Produto();
		p51.setValor(11.49f);
		p51.setObservacao("embalagem com 250g");
		p51.setValidade(sdf.parse("12/11/2024"));
		p51.setArmazenamento("F151");
		p51.setCodLote(1051L);
		p51.setData(sdf.parse("30/06/2024"));
		p51.setNome("Café Torrado e Moído Melitta");
		p51.setId(152589641L);
		p51.setQuantidade(32);

		Produto p52 = new Produto();
		p52.setValor(18.99f);
		p52.setObservacao("embalagem com 2kg");
		p52.setValidade(sdf.parse("31/12/2024"));
		p52.setArmazenamento("F152");
		p52.setCodLote(1052L);
		p52.setData(sdf.parse("14/08/2024"));
		p52.setNome("Farinha de Trigo Dona Benta");
		p52.setId(152631478L);
		p52.setQuantidade(15);

		Produto p53 = new Produto();
		p53.setValor(5.75f);
		p53.setObservacao("caixa com 10 unidades");
		p53.setValidade(sdf.parse("25/10/2024"));
		p53.setArmazenamento("F153");
		p53.setCodLote(1053L);
		p53.setData(sdf.parse("08/03/2024"));
		p53.setNome("Sabonete Lux Suave");
		p53.setId(152752369L);
		p53.setQuantidade(20);

		Produto p54 = new Produto();
		p54.setValor(3.99f);
		p54.setObservacao("embalagem com 500ml");
		p54.setValidade(sdf.parse("15/09/2024"));
		p54.setArmazenamento("F154");
		p54.setCodLote(1054L);
		p54.setData(sdf.parse("20/04/2024"));
		p54.setNome("Detergente Ypê Neutro");
		p54.setId(152896347L);
		p54.setQuantidade(28);

		Produto p55 = new Produto();
		p55.setValor(14.5f);
		p55.setObservacao("pacote com 1kg");
		p55.setValidade(sdf.parse("28/11/2024"));
		p55.setArmazenamento("F155");
		p55.setCodLote(1055L);
		p55.setData(sdf.parse("11/05/2024"));
		p55.setNome("Macarrão Espaguete Renata");
		p55.setId(152965874L);
		p55.setQuantidade(22);

		Produto p56 = new Produto();
		p56.setValor(4.25f);
		p56.setObservacao("caixa com 6 unidades");
		p56.setValidade(sdf.parse("15/09/2024"));
		p56.setArmazenamento("F156");
		p56.setCodLote(1056L);
		p56.setData(sdf.parse("20/04/2024"));
		p56.setNome("Sabão em Barra Ypê 200g");
		p56.setId(152965875L);
		p56.setQuantidade(40);

		Produto p57 = new Produto();
		p57.setValor(22.99f);
		p57.setObservacao("embalagem com 400g");
		p57.setValidade(sdf.parse("30/11/2024"));
		p57.setArmazenamento("F157");
		p57.setCodLote(1057L);
		p57.setData(sdf.parse("14/08/2024"));
		p57.setNome("Presunto Fatiado Sadia 400g");
		p57.setId(152631479L);
		p57.setQuantidade(15);

		Produto p58 = new Produto();
		p58.setValor(6.99f);
		p58.setObservacao("pacote com 500g");
		p58.setValidade(sdf.parse("25/10/2024"));
		p58.setArmazenamento("F158");
		p58.setCodLote(1058L);
		p58.setData(sdf.parse("08/03/2024"));
		p58.setNome("Arroz Branco Tio João 500g");
		p58.setId(152752370L);
		p58.setQuantidade(20);

		Produto p59 = new Produto();
		p59.setValor(3.49f);
		p59.setObservacao("sabor maçã");
		p59.setValidade(sdf.parse("20/09/2024"));
		p59.setArmazenamento("F159");
		p59.setCodLote(1059L);
		p59.setData(sdf.parse("01/07/2024"));
		p59.setNome("Suco de Maçã Jumex 1L");
		p59.setId(152457897L);
		p59.setQuantidade(25);

		Produto p60 = new Produto();
		p60.setValor(8.49f);
		p60.setObservacao("pote com 500g");
		p60.setValidade(sdf.parse("10/11/2024"));
		p60.setArmazenamento("F160");
		p60.setCodLote(1060L);
		p60.setData(sdf.parse("28/06/2024"));
		p60.setNome("Manteiga Aviação 500g");
		p60.setId(152589642L);
		p60.setQuantidade(32);

		Produto p61 = new Produto();
		p61.setValor(16.99f);
		p61.setObservacao("embalagem com 1kg");
		p61.setValidade(sdf.parse("31/12/2024"));
		p61.setArmazenamento("F161");
		p61.setCodLote(1061L);
		p61.setData(sdf.parse("15/04/2024"));
		p61.setNome("Açúcar Mascavo Guarani 1kg");
		p61.setId(151985624L);
		p61.setQuantidade(18);

		Produto p62 = new Produto();
		p62.setValor(9.75f);
		p62.setObservacao("pacote com 250g");
		p62.setValidade(sdf.parse("28/08/2024"));
		p62.setArmazenamento("F162");
		p62.setCodLote(1062L);
		p62.setData(sdf.parse("11/01/2024"));
		p62.setNome("Café Solúvel 3 Corações 250g");
		p62.setId(151798624L);
		p62.setQuantidade(25);

		Produto p63 = new Produto();
		p63.setValor(14.25f);
		p63.setObservacao("embalagem com 1kg");
		p63.setValidade(sdf.parse("30/09/2024"));
		p63.setArmazenamento("F163");
		p63.setCodLote(1063L);
		p63.setData(sdf.parse("22/03/2024"));
		p63.setNome("Farinha de Mandioca Yoki 1kg");
		p63.setId(151578935L);
		p63.setQuantidade(40);

		

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5,p6,p7,p8,p9,p49,p50,p51,p52,p53,p54,p55,p56,p57,p58,p59,p60,p61,p62,p63));
	*/
	}

}
