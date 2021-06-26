package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestCalculadora {

	private static Calculadora calc;

	@BeforeAll
	static void inicializa() {
		calc = new Calculadora();
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

	@DisplayName("Testa a soma de dois numeros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	void testSubtracao() {
		int sub = calc.subtracao(4, 5);		
		Assertions.assertEquals(-1, sub);	
	}

	@Test
	void testMultiplicacao() {
		int mult = calc.multiplicacao(4, 5);		
		Assertions.assertEquals(20, mult);	
	}

	@Test
	void testDivisao() {
		int div = calc.divisao(20, 5);		
		Assertions.assertEquals(4, div);	
	}

	@Test
	void testSomatoria() {
		int som = calc.somatoria(5);
		Assertions.assertEquals(15, som);
	}

	@DisplayName("Verifica se numero eh positvo")
	@Test
	void testEhPositivo() {
		boolean retorno = calc.ehPositivo(100);
		Assertions.assertTrue(retorno);
	}
	
	@DisplayName("Verifica se numero eh negativo")
	@Test
	void testEhPositivo2() {
		boolean retorno = calc.ehPositivo(-100);
		Assertions.assertFalse(retorno);
	}

	@DisplayName("Compara dois numeros iguais")
	@Test
	void testCompara() {
		int retorno = calc.compara(100, 100);
		Assertions.assertEquals(0, retorno);
	}
	
	@DisplayName("Compara a maior que b")
	@Test
	void testCompara2() {
		int retorno = calc.compara(107, 100);
		Assertions.assertEquals(1, retorno);
	}
	
	@DisplayName("Compara a menor que b")
	@Test
	void testCompara3() {
		int retorno = calc.compara(7, 100);
		Assertions.assertEquals(-1, retorno);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			calc.divisao(8, 0);
			fail("Excecao nao lancada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class, () -> calc.divisao(8, 0));
	}
}
