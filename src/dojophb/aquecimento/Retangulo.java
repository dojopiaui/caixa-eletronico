package dojophb.aquecimento;

public class Retangulo {

  private double base, altura;
  
  public Retangulo(double base, double altura) {
    if (base < 0 || altura < 0) {
      throw new IllegalArgumentException("A base e/ou altura não podem ser negativos.");
    }
    this.base = base;
    this.altura = altura;
  }

  public double area() {
    return this.base * this.altura;
  }

  public double perimetro() {
    return this.base * 2 + this.altura * 2;
  }

}
