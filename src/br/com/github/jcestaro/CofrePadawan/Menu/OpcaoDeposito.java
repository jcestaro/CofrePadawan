package br.com.github.jcestaro.CofrePadawan.Menu;

public class OpcaoDeposito implements Opcao {
    private final int codigo = 1;
    private final String descricao = "Depósito";

    @Override
    public void disparaAcao() {
        System.out.println("Teste");
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
