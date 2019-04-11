package br.com.github.jcestaro.CofrePadawan.Menu;

import br.com.github.jcestaro.CofrePadawan.Cofre;
import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class OpcaoSaquePorDinheiro implements Opcao {

    private final int codigo = 2;
    private final String descricao = "Saque por dinheiro";

    @Override
    public void disparaAcao() {
        boolean temDinheiroNoCofre = verificaSeTemDinheiroNoCofre();
        if (temDinheiroNoCofre){
            exibeListaOpcoesParaSaque();
            validaESaca(Cofre.getInstance(), pegaOpcaoEscolhida());
        }
    }

    private  boolean verificaSeTemDinheiroNoCofre () {
        BigDecimal saldoTotal = Cofre.getInstance().buscarSaldoTotal();

        if (saldoTotal.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Não é possível sacar, o cofre está vazio!" + System.lineSeparator());
            return false;
        }
        return true;
    }

    private void exibeListaOpcoesParaSaque() {
        Cofre.getInstance().transformaOpcoesMoedasECedulasEmLista().forEach(System.out::println);

        System.out.println();
        System.out.println("Escolha uma opção para saque: ");
    }

    private void validaESaca (Cofre cofre, int opcaoEscolhida) {
        try {
            Dinheiro dinheiroParaSaque = cofre.validaCodigoDoDinheiro(opcaoEscolhida);
            cofre.saca(dinheiroParaSaque);
            System.out.println();
        } catch (NoSuchElementException ex) {
            System.out.println();
            System.out.println("Opção inválida, escolha uma outra opção.");
            validaESaca(cofre, pegaOpcaoEscolhida());
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
