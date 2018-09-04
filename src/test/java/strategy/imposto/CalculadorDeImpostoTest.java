package strategy.imposto;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CalculadorDeImpostoTest {

    @Test
    public void deve_CalcularCorretamenteOImposto_QuandoInformado() {

        Imposto iss = new ISS();
        ICMS icms = new ICMS();

        Orcamento orcamento = new Orcamento(500.0);

        CalculadorDeImposto calculador = new CalculadorDeImposto();

        double vlIss = calculador.realizaCalculo(orcamento, iss);
        double vlIcms = calculador.realizaCalculo(orcamento, icms);

        System.out.println(vlIss);
        System.out.println(vlIcms);

        assertThat(vlIss, equalTo(50.0));
        assertThat(vlIcms, equalTo(300.0));

    }

}