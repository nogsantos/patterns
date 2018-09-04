package strategy.investimento;

import java.util.Random;

public class Moderado implements Investimento {

    private Random random;

    public Moderado(Random random) {
        this.random = random;
    }

    @Override
    public double calcula(Conta conta) {

        if (random.nextInt(2) == 0) {
            return conta.getSaldo() * 0.025;
        } else {

            return conta.getSaldo() * 0.0007;
        }

    }
}
