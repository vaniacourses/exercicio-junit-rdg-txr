package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe de testes para Carrinho")
public class CarrinhoTest {
    
    private Carrinho carrinho;
    private Produto p1;
    private Produto p2;
    private Produto p3;
    private Produto p4;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        p1 = new Produto("Notebook", 3500.00);
        p2 = new Produto("Mouse", 150.00);
        p3 = new Produto("Teclado", 100.00);
        p4 = new Produto("Monitor", 450.00);
    }

    @DisplayName("Adiciona itens ao carrinho")
    @Test
    public void testAddItem() {
        carrinho.addItem(p1);
        assertEquals(1, carrinho.getQtdeItems());
    }

    public void testAddItem() {
        carrinho.addItem(p2);
        assertEquals(2, carrinho.getQtdeItems());
    }
    
    @DisplayName("Remove item existente do carrinho")
    @Test
    public void testRemoveItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(p1);
        carrinho.removeItem(p1);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @DisplayName("Lança exceção ao remover item inexistente")
    @Test
    public void testRemoveItemInexistente() {
        assertThrows(ProdutoNaoEncontradoException.class,
                () -> carrinho.removeItem(p1));
    }

    @DisplayName("Calcula valor total corretamente")
    @Test
    public void testGetValorTotal() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);
        carrinho.addItem(p3);
        carrinho.addItem(p4);
        double total = carrinho.getValorTotal();
        assertEquals(4200.00, total, 0.01);
    }

    @DisplayName("Esvazia carrinho")
    @Test
    public void testEsvaziaCarrinho() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);
        carrinho.addItem(p3);
        carrinho.addItem(p4);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.01);
    }
}
