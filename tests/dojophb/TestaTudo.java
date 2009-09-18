package dojophb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dojophb.aquecimento.RetanguloTest;
import dojophb.problema.CaixaEletronicoTest;

@RunWith(Suite.class)
@SuiteClasses({RetanguloTest.class, CaixaEletronicoTest.class})
public class TestaTudo {
  
}
