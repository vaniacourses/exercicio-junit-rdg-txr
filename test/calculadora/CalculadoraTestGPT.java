package calculadora;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraTestGPT {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Teste de soma com números positivos")
    void testSomaPositivos() {
        assertEquals(7, calculadora.soma(3, 4));
    }

    @Test
    @DisplayName("Teste de soma com números negativos")
    void testSomaNegativos() {
        assertEquals(-9, calculadora.soma(-4, -5));
    }

    @Test
    @DisplayName("Teste de subtração com números positivos")
    void testSubtracao() {
        assertEquals(1, calculadora.subtracao(5, 4));
    }

    @Test
    @DisplayName("Teste de subtração resultando em valor negativo")
    void testSubtracaoNegativa() {
        assertEquals(-3, calculadora.subtracao(2, 5));
    }

    @Test
    @DisplayName("Teste de multiplicação simples")
    void testMultiplicacao() {
        assertEquals(20, calculadora.multiplicacao(4, 5));
    }

    @Test
    @DisplayName("Teste de multiplicação com zero")
    void testMultiplicacaoZero() {
        assertEquals(0, calculadora.multiplicacao(10, 0));
    }

    @Test
    @DisplayName("Teste de divisão inteira")
    void testDivisao() {
        assertEquals(2, calculadora.divisao(10, 5));
    }

    @Test
    @DisplayName("Teste de divisão com resto (truncada)")
    void testDivisaoComResto() {
        assertEquals(3, calculadora.divisao(7, 2)); // divisão inteira
    }

    @Test
    @DisplayName("Teste de divisão por zero lança exceção")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(10, 0));
    }

    @Test
    @DisplayName("Teste de somatória de 0 até 5")
    void testSomatoria() {
        assertEquals(15, calculadora.somatoria(5)); // 0+1+2+3+4+5
    }

    @Test
    @DisplayName("Teste de somatória com n = 0")
    void testSomatoriaZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    @DisplayName("Teste de número positivo")
    void testEhPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    @DisplayName("Teste de número negativo")
    void testEhPositivoComNegativo() {
        assertFalse(calculadora.ehPositivo(-1));
    }

    @Test
    @DisplayName("Teste de zero como positivo")
    void testEhPositivoZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    @DisplayName("Teste de comparação: iguais")
    void testComparaIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    @DisplayName("Teste de comparação: maior")
    void testComparaMaior() {
        assertEquals(1, calculadora.compara(7, 3));
    }

    @Test
    @DisplayName("Teste de comparação: menor")
    void testComparaMenor() {
        assertEquals(-1, calculadora.compara(2, 9));
    }
}
