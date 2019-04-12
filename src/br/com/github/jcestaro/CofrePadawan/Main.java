package br.com.github.jcestaro.CofrePadawan;

import br.com.github.jcestaro.CofrePadawan.Menu.Opcao;
import java.util.*;

public class Main {

    static void exibeMenuPrincipal () {
        Cofre.getInstance().exibeMenuPrincipal();
        System.out.println();
        System.out.println("Escolha uma opção: ");
        System.out.println();
        disparaAcaoDoMenu(pegaOpcaoEscolhida());
    }

    static void disparaAcaoDoMenu (int opcaoEscolhida) {
        try {
            Opcao opcaoMenu = Cofre.getInstance().validaOpcaoDoMenu(opcaoEscolhida);
            opcaoMenu.disparaAcao();
            exibeMenuPrincipal();
        } catch (NoSuchElementException ex) {
            System.out.println("Opção inválida, escolha uma outra opção.");
            disparaAcaoDoMenu(pegaOpcaoEscolhida());
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

    public static void main(String[] args) {

        exibeMenuPrincipal();
    }
}
