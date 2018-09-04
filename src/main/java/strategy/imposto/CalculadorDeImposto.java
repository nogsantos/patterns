package strategy.imposto;

public class CalculadorDeImposto {

    public double realizaCalculo(Orcamento orcamento, Imposto imposto) {
        return imposto.calcula(orcamento);
    }

}
