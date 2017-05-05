import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import entidades.Pergunta;
import entidades.Resposta;
import service.PerguntaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PerguntaTestCase {

	PerguntaService perguntaService;

	@Before
	public void init() {
		perguntaService = new PerguntaService();
	}

//	@Test
	public void A_inserir() {
		Pergunta perg = new Pergunta("Qual é a pergunta de teste?", "junit@carros.com");
		perguntaService.inserir(perg);
		List<Pergunta> listaPergunta = perguntaService.findAll();

		assertTrue(listaPergunta.size() > 0);
	}

//	@Test
	public void B_responder() {
		List<Pergunta> listaPergunta = perguntaService.findAll();
		Pergunta pergBanco = listaPergunta.get(0);
		Resposta resposta = new Resposta("Resposta Teste!", pergBanco.getUserEmail(), false);

		assertTrue(perguntaService.adicionarResposta(pergBanco, resposta) > 0);
	}

}
