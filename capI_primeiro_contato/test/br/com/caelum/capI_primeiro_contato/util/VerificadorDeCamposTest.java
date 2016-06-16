package br.com.caelum.capI_primeiro_contato.util;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.capI_primeiro_contato.model.Carro;
import br.com.caelum.capI_primeiro_contato.model.Cliente;

@SuppressWarnings("deprecation")
public class VerificadorDeCamposTest {

	private static final String ENDERECO_CLIENTE = "endereco";
	private static final String NOME_CLIENTE = "nome";
	private static final String MODELO_CARRO = "modelo";
	private static final String COR_CARRO = "cor";

	private VerificadorDeCampos verificadorDeCampos;

	@Before
	public void inicializaTeste() {
		verificadorDeCampos = new VerificadorDeCampos();
	}

	@Test
	public void todosOsCamposNulosEmCliente() {
		Cliente cliente = new Cliente();

		List<String> camposNulosEm = verificadorDeCampos.pegaCamposNulosEm(cliente);

		assertEquals(2, camposNulosEm.size());
		assertEquals(NOME_CLIENTE, camposNulosEm.get(0));
		assertEquals(ENDERECO_CLIENTE, camposNulosEm.get(1));
	}

	@Test
	public void nomeNuloEmCliente() {
		Cliente cliente = new Cliente();
		cliente.endereco = "rua das laranjeiras, 123";

		List<String> camposNulos = verificadorDeCampos.pegaCamposNulosEm(cliente);

		assertEquals(1, camposNulos.size());
		assertEquals(NOME_CLIENTE, camposNulos.get(0));
	}

	@Test
	public void enderecoNuloEmCliente() {
		Cliente cliente = new Cliente();
		cliente.nome = "José Das Couves";

		List<String> camposNulos = verificadorDeCampos.pegaCamposNulosEm(cliente);

		assertEquals(1, camposNulos.size());
		assertEquals(ENDERECO_CLIENTE, camposNulos.get(0));
	}

	@Test
	public void nenhumCampoNuloEmCliente() {
		Cliente cliente = new Cliente();
		cliente.nome = "José Das Couves";
		cliente.endereco = "rua das abóboras, 456";

		List<String> camposNulos = verificadorDeCampos.pegaCamposNulosEm(cliente);

		assertEquals(0, camposNulos.size());
	}

	@Test
	public void todosOsCamposNulosEmCarro() {
		Carro carro = new Carro();
		List<String> camposNulos = verificadorDeCampos.pegaCamposNulosEm(carro);

		assertEquals(2, camposNulos.size());
		assertEquals(COR_CARRO, camposNulos.get(0));
		assertEquals(MODELO_CARRO, camposNulos.get(1));
	}

	@Test
	public void modeloNuloEmCarro() {
		Carro carro = new Carro();
		carro.cor = "branco";

		List<String> camposNulos = verificadorDeCampos.pegaCamposNulosEm(carro);

		assertEquals(1, camposNulos.size());
		assertEquals(MODELO_CARRO, camposNulos.get(0));
	}

	@Test
	public void corNuloEmCarro() {
		Carro carro = new Carro();
		carro.modelo = "civic";

		List<String> camposNulos = verificadorDeCampos.pegaCamposNulosEm(carro);

		assertEquals(1, camposNulos.size());
		assertEquals(COR_CARRO, camposNulos.get(0));
	}

	@Test
	public void nenhumNuloEmCarro() {
		Carro carro = new Carro();
		carro.modelo = "civic";
		carro.cor = "azul";

		assertEquals(0, verificadorDeCampos.pegaCamposNulosEm(carro).size());
	}

	@Test
	public void buscaAtributosQueContemAStringDesejadaEmSeuValor() {
		Cliente cliente = new Cliente();
		cliente.nome = "jonas";

		assertEquals(1, verificadorDeCampos.pegaAtributosQueContemComoValorA("jonas", cliente).size());
		assertEquals(NOME_CLIENTE, verificadorDeCampos.pegaAtributosQueContemComoValorA("jonas", cliente).get(0));
	}
}
