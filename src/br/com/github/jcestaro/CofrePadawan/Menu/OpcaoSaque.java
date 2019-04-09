package br.com.github.jcestaro.CofrePadawan.Menu;

public class OpcaoSaque implements Opcao {

    private final int codigo = 2;
    private final String descricao = "Saque";

    @Override
    public void disparaAcao() {

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
