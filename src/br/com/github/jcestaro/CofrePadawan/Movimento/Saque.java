package br.com.github.jcestaro.CofrePadawan.Movimento;

import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import java.util.List;

public class Saque extends Movimento{

    @Override
    public boolean ehDeposito() {
        return false;
    }

    @Override
    public void sacar(Dinheiro valor, List<Dinheiro> listaDinheiro) {
        listaDinheiro.remove(valor);
    }
}
