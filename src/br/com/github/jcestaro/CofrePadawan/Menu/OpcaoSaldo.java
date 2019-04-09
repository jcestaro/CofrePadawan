package br.com.github.jcestaro.CofrePadawan.Menu;

import br.com.github.jcestaro.CofrePadawan.Cofre;

import java.text.NumberFormat;

public class OpcaoSaldo implements Opcao {
    private final int codigo = 4;
    private final String descricao = "Saldo";

    @Override
    public void disparaAcao() {
        exibeSaldoTotal();
    }

    private void exibeSaldoTotal () {
        System.out.println(NumberFormat.getCurrencyInstance().format(Cofre.getInstance().buscarSaldoTotal()));
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
