package dojophb.problema;

import static org.junit.Assert.*;
import org.junit.*;

public class CaixaEletronicoTest {

  CaixaEletronico caixa, caixa2;
  
  @Before
  public void inicializa() {
    this.caixa = new CaixaEletronico(new int[]{20,50,100,10});
    this.caixa2 = new CaixaEletronico(new int[]{20,50,5,100,10});
  }
  
  @Test
  public void valoresDisponiveis() {
    assertArrayEquals(new int[]{100,50,20,10}, caixa.getValoresCedulas());
    assertArrayEquals(new int[]{100,50,20,10,5}, caixa2.getValoresCedulas());
  }

  @Test
  public void saquesValores() {
    assertArrayEquals(new int[] {0,0,1,1}, caixa.saque(30));
    assertArrayEquals(new int[] {1,0,1,1}, caixa.saque(130));
    assertArrayEquals(new int[] {0,1,2,0}, caixa.saque(90));
    assertArrayEquals(new int[] {4,1,2,0}, caixa.saque(490));
    assertArrayEquals(new int[] {4,1,2,0,1}, caixa2.saque(495));
  }

  @Test(expected = IllegalArgumentException.class)
  public void saqueInvalido() {
    caixa.saque(491);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void saqueNegativo() {
    caixa.saque(-490);
  }
  
  @Test
  public void saqueExtenso(){
    assertEquals("Nenhuma nota será entregue.", caixa.saqueExtenso(0));
    assertEquals("Entregar 1 nota de R$100,00, 1 nota de R$20,00 e 1 nota de R$10,00.", caixa.saqueExtenso(130));
    assertEquals("Entregar 1 nota de R$50,00, 1 nota de R$10,00 e 1 nota de R$5,00.", caixa2.saqueExtenso(65));
    assertEquals("Entregar 1 nota de R$5,00.", caixa2.saqueExtenso(5));
  }
  
}
