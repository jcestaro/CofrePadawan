package br.com.github.jcestaro.CofrePadawan;

import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;

import java.math.MathContext;
import java.util.*;

public class Main {

    static Cofre criaCofre () {
        Cofre novoCofre = new Cofre();

        return novoCofre;
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
            validaEDeposita(cofre, pegaOpcaoEscolhidaTipoDeposito());
        }
    }

    static int pegaOpcaoEscolhidaTipoDeposito () {
        Scanner scanner = new Scanner(System.in);
        try {
            int opcaoEscolhida = scanner.nextInt();
            return opcaoEscolhida;

        } catch (InputMismatchException ex) {
            System.out.println("Opção inválida, escolha uma outra opção.");
            return pegaOpcaoEscolhidaTipoDeposito();
        }
    }

    static void exibeSaldoTotal (Cofre cofre) {
        cofre.exibeSaldo();
        System.out.println(cofre.saldoTotal);
    }

    static void exibeListaDinheiro (Cofre cofre) {
        System.out.println(cofre.listaDinheiro);
    }


    public static void main(String[] args) {


        Cofre novoCofreCriado = criaCofre();

        exibeListaOpcoes(novoCofreCriado);

        validaEDeposita(novoCofreCriado, pegaOpcaoEscolhidaTipoDeposito());

        exibeListaDinheiro(novoCofreCriado);
        exibeSaldoTotal(novoCofreCriado);

    }
}
