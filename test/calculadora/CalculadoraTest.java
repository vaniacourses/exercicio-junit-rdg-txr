package calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	@Test
	public void somaTest() {
		Calculadora calc = new Calculadora();
		int soma = calc.soma(5, 3);
		
		Assertions.assertEquals(8, soma);
	}
}
