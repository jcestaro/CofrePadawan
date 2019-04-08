package br.com.github.jcestaro.CofrePadawan.Enum;

import java.math.BigDecimal;

public enum Moeda {
    CINCO_CENTAVOS(new BigDecimal(0.05)),
    DEZ_CENTAVOS(new BigDecimal(0.10)),
    VINTE_CINCO_CENTAVOS(new BigDecimal(0.25)),
    CINQUENTA_CENTAVOS(new BigDecimal(0.50)),
    UM_REAL(new BigDecimal(1.00));

    private final BigDecimal valor;

    Moeda(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
