package strategy.investimento;

public class Investidor {

    public void investe(Conta conta, Investimento investimento) {
        double resultado = investimento.calcula(conta);
        conta.deposita(resultado * 0.75);
    }

}
