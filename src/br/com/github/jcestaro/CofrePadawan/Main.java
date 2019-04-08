package br.com.github.jcestaro.CofrePadawan;

import br.com.github.jcestaro.CofrePadawan.Enum.Cedula;
import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import br.com.github.jcestaro.CofrePadawan.Enum.Moeda;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Cofre cofre = new Cofre();
        Scanner scanner = new Scanner(System.in);

        cofre.transformaOpcoesMoedasECedulasEmLista().forEach(opcao -> System.out.println(opcao));

        System.out.println("Escolha uma opção para depósito: ");

        try {
            int opcaoEscolhida = scanner.nextInt();

            cofre.validaCodigoDoDinheiro(opcaoEscolhida);
        } catch (InputMismatchException ex) {
            System.out.println("Opção inválida!");
        }

    }
}
