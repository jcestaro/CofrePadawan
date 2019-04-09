package br.com.github.jcestaro.CofrePadawan.Menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public List<Opcao> listaOpcoes = new ArrayList<>();
    Opcao opcaoDeposito = new OpcaoDeposito();
    Opcao opcaoSaque = new OpcaoSaque();
    Opcao opcaoSaldo = new OpcaoSaldo();
    Opcao opcaoFecharCofre = new OpcaoFechar();

    public void montaMenu () {
        listaOpcoes.add(opcaoDeposito);
        listaOpcoes.add(opcaoSaque);
        listaOpcoes.add(opcaoSaldo);
        listaOpcoes.add(opcaoFecharCofre);
    }

    @Override
    public String toString() {
        return opcaoDeposito + "\n"
                + opcaoSaque + "\n"
                + opcaoSaldo + "\n"
                + opcaoFecharCofre;
    }
}
