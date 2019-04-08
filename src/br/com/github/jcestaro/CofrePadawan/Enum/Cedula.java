package br.com.github.jcestaro.CofrePadawan.Enum;

import java.math.BigDecimal;

public enum Cedula {
    DOIS_REAIS(new BigDecimal(2.00)),
    CINCO_REAIS(new BigDecimal(5.00)),
    DEZ_REAIS(new BigDecimal(10.00)),
    VINTE_REAIS(new BigDecimal(20.00)),
    CINQUENTA_REAIS(new BigDecimal(50.00)),
    CEM_REAIS(new BigDecimal(100.00));


    private final BigDecimal valor;

    Cedula(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
