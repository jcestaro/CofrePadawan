package br.com.github.jcestaro.CofrePadawan.Enum;

import java.math.BigDecimal;

public enum Cedula implements Dinheiro {
    DOIS_REAIS(new BigDecimal(2.00), 6, "Dois Reais"),
    CINCO_REAIS(new BigDecimal(5.00), 7, "Cinco Reais"),
    DEZ_REAIS(new BigDecimal(10.00), 8, "Dez Reais"),
    VINTE_REAIS(new BigDecimal(20.00), 9, "Vinte Reais"),
    CINQUENTA_REAIS(new BigDecimal(50.00), 10, "Cinquenta Reais"),
    CEM_REAIS(new BigDecimal(100.00), 11, "Cem Reais");


    private final BigDecimal valor;
    private final int codigo;
    private final String descricao;

    Cedula(BigDecimal valor, int codigo, String descricao) {
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
