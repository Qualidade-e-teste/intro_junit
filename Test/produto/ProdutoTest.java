package produto;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	static Produto livro;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		livro = new Produto("Introdução ao Teste de Software", 100.00);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testProduto() {
		Assertions.assertAll("livro", () -> assertEquals("Introdução ao Teste de Software", livro.getNome()),
				() -> assertTrue(100.00 == livro.getPreco()));
	}

	@Test
	void testSetNome() {
		livro.setNome("Introdução");
		Assertions.assertEquals("Introdução", livro.getNome());
	}

	@Test
	void testSetPreco() {
		livro.setPreco(90.00);
		Assertions.assertEquals(90.00, livro.getPreco());
	}

	@Test
	void testEqualsObject() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
		boolean retorno = livro2.equals(livro);
		assertNotSame(livro, livro2);
		Assertions.assertTrue(retorno);
	}

	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(livro.getPreco(), equalTo(100.00));
		assertThat(livro.getNome(), notNullValue());
		assertThat(livro.getNome(), containsString("Teste"));
		assertThat(livro, instanceOf(Produto.class));
	}
}
