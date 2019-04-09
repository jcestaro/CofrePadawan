package br.com.github.jcestaro.CofrePadawan;

import br.com.github.jcestaro.CofrePadawan.Menu.Opcao;
import java.text.NumberFormat;
import java.util.*;

public class Main {

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

    static void exibeListaDinheiro (Cofre cofre) {
        System.out.println(cofre.listaDinheiro);
    }


    public static void main(String[] args) {

        exibeMenuPrincipal(Cofre.getInstance());
        disparaAcaoDoMenu(Cofre.getInstance(), pegaOpcaoEscolhida());

        exibeListaDinheiro(Cofre.getInstance());

    }
}
