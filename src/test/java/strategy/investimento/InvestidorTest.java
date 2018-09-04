package strategy.investimento;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class InvestidorTest {

    @Test
    public void deve_Investir_DeAcordoComOPerfil() {

        Random random = new Random();

        Conservador conservador = new Conservador();
        Moderado moderado = new Moderado(random);
        Arrojado arrojado = new Arrojado(random);

        Conta contaConservador = new Conta();
        contaConservador.setSaldo(50.0);

        Conta contaModerado = new Conta();
        contaModerado.setSaldo(50.0);

        Conta contaArrojado = new Conta();
        contaArrojado.setSaldo(50.0);

        Investidor investidor = new Investidor();

        investidor.investe(contaConservador, conservador);
        System.out.println(contaConservador.getSaldo());

        investidor.investe(contaModerado, moderado);
        System.out.println(contaModerado.getSaldo());

        investidor.investe(contaArrojado, arrojado);
        System.out.println(contaArrojado.getSaldo());

        assertThat(contaConservador.getSaldo(), greaterThan(50.00));
        assertThat(contaModerado.getSaldo(), greaterThan(50.00));
        assertThat(contaArrojado.getSaldo(), greaterThan(50.00));

    }
}