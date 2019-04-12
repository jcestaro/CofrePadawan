package br.com.github.jcestaro.CofrePadawan.Menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public List<Opcao> listaOpcoes = new ArrayList<>();
    Opcao opcaoDeposito = new OpcaoDeposito();
    Opcao opcaoSaquePorDinheiro = new OpcaoSaquePorDinheiro();
    Opcao opcaoSaquePorValor = new OpcaoSaquePorValor();
    Opcao opcaoSaldo = new OpcaoSaldo();
    Opcao opcaoFecharCofre = new OpcaoFechar();

    public void montaMenu () {
        listaOpcoes.add(opcaoDeposito);
        listaOpcoes.add(opcaoSaquePorDinheiro);
        listaOpcoes.add(opcaoSaquePorValor);
        listaOpcoes.add(opcaoSaldo);
        listaOpcoes.add(opcaoFecharCofre);
    }

    @Override
    public String toString() {
        return opcaoDeposito + "\n"
                + opcaoSaquePorDinheiro + "\n"
                + opcaoSaquePorValor + "\n"
                + opcaoSaldo + "\n"
                + opcaoFecharCofre;
    }
}
