package carrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

class CarrinhoTest {
	
	static Carrinho car;
	static Produto livro;
	static Produto livro2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		car = new Carrinho();
		livro = new Produto("Introdução ao Teste de Software", 100.00);
		livro2 = new Produto("Introdução ao Teste de Software v2", 90.00);
	}

	@BeforeEach
	void setUp() throws Exception {
		car.esvazia();
		car.addItem(livro);
	}

	@Test
	void testAddItem() {
		car.addItem(livro2);
		Assertions.assertEquals(2, car.getQtdeItems());
	}

	@DisplayName("Remove item incorretamente")
	@Test
	void testRemoveItem() {
		try {
			car.removeItem(livro2);
		} catch (ProdutoNaoEncontradoException e) {
			Assertions.assertSame(ProdutoNaoEncontradoException.class, e.getClass());
		}
	}
	
	@DisplayName("Remove item corretamente")
	@Test
	void testRemoveItem2() {
		try {
			car.removeItem(livro);
			Assertions.assertEquals(0, car.getQtdeItems());
		} catch (ProdutoNaoEncontradoException e) {
			Assertions.assertSame(ProdutoNaoEncontradoException.class, e.getClass());
		}
	}

	@Test
	void testGetQtdeItems() {
		Assertions.assertEquals(1, car.getQtdeItems());
	}

	@Test
	void testEsvazia() {
		car.esvazia();
		Assertions.assertEquals(0, car.getQtdeItems());
	}
	
	@Test
	void testGetValorTotal() {
		double valor = car.getValorTotal();
		Assertions.assertEquals(100.00, valor);
	}

}
