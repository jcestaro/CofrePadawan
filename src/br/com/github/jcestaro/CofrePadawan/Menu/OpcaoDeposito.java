package br.com.github.jcestaro.CofrePadawan.Menu;

import br.com.github.jcestaro.CofrePadawan.Cofre;
import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class OpcaoDeposito implements Opcao {
    private final int codigo = 1;
    private final String descricao = "Depósito";
    
    @Override
    public void disparaAcao() {
        exibeListaOpcoesParaDeposito(Cofre.getInstance());
        validaEDeposita(Cofre.getInstance(), pegaOpcaoEscolhida());
    }

    private void exibeListaOpcoesParaDeposito(Cofre cofre) {
        cofre.transformaOpcoesMoedasECedulasEmLista().forEach(opcao -> System.out.println(opcao));

        System.out.println("Escolha uma opção para depósito: ");
    }

    private void validaEDeposita (Cofre cofre, int opcaoEscolhida) {
        try {
            Dinheiro dinheiroParaDeposito = cofre.validaCodigoDoDinheiro(opcaoEscolhida);
            cofre.deposita(dinheiroParaDeposito);
        } catch (NoSuchElementException ex) {
            System.out.println("Opção inválida, escolha uma outra opção.");
            validaEDeposita(cofre, pegaOpcaoEscolhida());
        }
    }

    private int pegaOpcaoEscolhida() {
        Scanner scanner = new Scanner(System.in);
        try {
            int opcaoEscolhida = scanner.nextInt();
            return opcaoEscolhida;

        } catch (InputMismatchException ex) {
            System.out.println("Opção inválida, escolha uma outra opção.");
            return pegaOpcaoEscolhida();
        }
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
