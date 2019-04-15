package br.com.github.jcestaro.CofrePadawan.Movimento;

import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import java.util.List;

public class Deposito implements Movimento{

    @Override
    public boolean ehDeposito() {
        return true;
    }

    @Override
    public void depositar(Dinheiro valor, List<Dinheiro> listaDinheiro) {
        listaDinheiro.add(valor);
    }

    public void sacar(Dinheiro valor, List<Dinheiro> listaDinheiro) {}
}
