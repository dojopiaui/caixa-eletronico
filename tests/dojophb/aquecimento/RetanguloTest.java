package dojophb.aquecimento;

import org.junit.*;

import dojophb.aquecimento.Retangulo;
import static junit.framework.Assert.*;

public class RetanguloTest {

  Retangulo ret;
  
  @Before
  public void inicializa() {
    ret = new Retangulo(3,5);
  }
  
  @Test
  public void area() {
    assertEquals(15.0, ret.area());
    assertEquals(6.0, new Retangulo(2,3).area());
    assertEquals(6.2, new Retangulo(2,3.1).area());
  }
  
  @Test
  public void perimetro() {
    assertEquals(16.0, ret.perimetro());
    assertEquals(10.0, new Retangulo(2,3).perimetro());
    assertEquals(10.2, new Retangulo(2,3.1).perimetro());
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void baseNegativa() {
    new Retangulo(-2,3);
  }

  @Test(expected = Exception.class)
  public void alturaNegativa() {
    new Retangulo(2,-3);
  }
}
