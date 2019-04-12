package br.com.github.jcestaro.CofrePadawan.Enum;

import java.math.BigDecimal;

public enum Moeda implements Dinheiro {
    CINCO_CENTAVOS(new BigDecimal(0.05), 1, "Cinco Centavos"),
    DEZ_CENTAVOS(new BigDecimal(0.10), 2, "Dez Centavos"),
    VINTE_CINCO_CENTAVOS(new BigDecimal(0.25), 3, "Vinte e Cinco Centavos"),
    CINQUENTA_CENTAVOS(new BigDecimal(0.50), 4, "Cinquenta Centavos"),
    UM_REAL(new BigDecimal(1.00), 5, "Um Real");

    private final BigDecimal valor;
    private final int codigo;
    private final String descricao;

    Moeda(BigDecimal valor, int codigo, String descricao) {
        this.valor = valor;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return getCodigo() + " - " + getDescricao();
    }
}
