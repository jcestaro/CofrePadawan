package br.com.github.jcestaro.CofrePadawan;

import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import br.com.github.jcestaro.CofrePadawan.Menu.Opcao;

import java.text.NumberFormat;
import java.util.*;

public class Main {

    static Cofre criaCofre () {
        Cofre novoCofre = new Cofre();

        return novoCofre;
    }

    static void exibeMenuPrincipal (Cofre cofre) {
        cofre.exibeMenuPrincipal();
        System.out.println("Escolha uma opção: ");
    }

    static void disparaAcaoDoMenu (Cofre cofre, int opcaoEscolhida) {
        try {
            Opcao opcaoMenu = cofre.validaOpcaoDoMenu(opcaoEscolhida);
            opcaoMenu.disparaAcao();
        } catch (NoSuchElementException ex) {
            System.out.println("Opção inválida, escolha uma outra opção.");
            disparaAcaoDoMenu(cofre, pegaOpcaoEscolhida());
        }
    }

    static void exibeListaOpcoes (Cofre cofre) {
        cofre.transformaOpcoesMoedasECedulasEmLista().forEach(opcao -> System.out.println(opcao));

        System.out.println("Escolha uma opção para depósito: ");
    }

    static void validaEDeposita (Cofre cofre, int opcaoEscolhida) {
        try {
            Dinheiro dinheiroParaDeposito = cofre.validaCodigoDoDinheiro(opcaoEscolhida);
            cofre.deposita(dinheiroParaDeposito);
        } catch (NoSuchElementException ex) {
            System.out.println("Opção inválida, escolha uma outra opção.");
            validaEDeposita(cofre, pegaOpcaoEscolhida());
        }
    }

    static int pegaOpcaoEscolhida() {
        Scanner scanner = new Scanner(System.in);
        try {
            int opcaoEscolhida = scanner.nextInt();
            return opcaoEscolhida;

        } catch (InputMismatchException ex) {
            System.out.println("Opção inválida, escolha uma outra opção.");
            return pegaOpcaoEscolhida();
        }
    }

    static void exibeSaldoTotal (Cofre cofre) {
        cofre.exibeSaldo();
        System.out.println(NumberFormat.getCurrencyInstance().format(cofre.saldoTotal));
    }

    static void exibeListaDinheiro (Cofre cofre) {
        System.out.println(cofre.listaDinheiro);
    }


    public static void main(String[] args) {

        Cofre novoCofreCriado = criaCofre();

        exibeMenuPrincipal(novoCofreCriado);
        disparaAcaoDoMenu(novoCofreCriado, pegaOpcaoEscolhida());

        exibeListaOpcoes(novoCofreCriado);

        validaEDeposita(novoCofreCriado, pegaOpcaoEscolhida());

        exibeListaDinheiro(novoCofreCriado);
        exibeSaldoTotal(novoCofreCriado);

    }
}
