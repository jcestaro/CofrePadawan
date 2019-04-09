package br.com.github.jcestaro.CofrePadawan.Menu;

public class OpcaoFechar implements Opcao {
    private final int codigo = 4;
    private final String descricao = "Fechar Cofre";

    @Override
    public void disparaAcao() {
        System.exit(0);
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
