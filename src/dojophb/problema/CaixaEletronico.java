package dojophb.problema;

import java.util.Arrays;

public class CaixaEletronico {

  private int[] valoresCedulas;
  
  public CaixaEletronico(int[] cedulas) {
    Arrays.sort(cedulas);
    int aux;
    for(int i=0; i < cedulas.length / 2; i++) {
      aux = cedulas[i];
      cedulas[i] = cedulas[cedulas.length-i-1];
      cedulas[cedulas.length-i-1] = aux;
    }
    this.valoresCedulas = cedulas;
  }

  public int[] getValoresCedulas() {
    return this.valoresCedulas;
  }

  public int[] saque(int valor) {
    if (valor < 0) {
      throw new IllegalArgumentException("Não é possível sacar um valor negativo.");
    }
    int[] resultado = new int[valoresCedulas.length];
    for (int i=0; i < valoresCedulas.length; i++) {
      resultado[i] = valor / valoresCedulas[i];
      valor = valor % valoresCedulas[i];
    }
    if (valor != 0) {
      throw new IllegalArgumentException("Não é possível efetuar o saque deste valor.");
    }
    return resultado;
  }

  public String saqueExtenso(int valor) {
      if (valor == 0)
        return "Nenhuma nota será entregue.";
      StringBuilder sb = new StringBuilder();
      sb.append("Entregar ");
      int tamInicial = sb.length();
      int[] qtdeCedulas = saque(valor);
      int posUltimo = -1;
      for (int i = 0; i < qtdeCedulas.length; i++){
        if (qtdeCedulas[i] > 0){          
          posUltimo = sb.length();
          sb.append(qtdeCedulas[i]).append(" nota").
            append(qtdeCedulas[i] == 1 ? " de " : "s de ").append("R$").
            append(valoresCedulas[i]).append(",00, ");
        }
      }
      if (posUltimo > tamInicial)
        sb.replace(posUltimo-2, posUltimo, " e ");
      sb.replace(sb.length()-2, sb.length(), ".");
      return sb.toString();
  }

}
