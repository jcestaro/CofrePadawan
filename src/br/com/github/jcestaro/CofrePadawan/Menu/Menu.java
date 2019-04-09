package br.com.github.jcestaro.CofrePadawan.Menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public List<Opcao> listaOpcoes = new ArrayList<>();
    Opcao opcaoDeposito = new OpcaoDeposito();

    public void montaMenu () {
        listaOpcoes.add(opcaoDeposito);
    }

    @Override
    public String toString() {
        return opcaoDeposito.getCodigo() + " - " + opcaoDeposito.getDescricao();
    }
}
