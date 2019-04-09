package br.com.github.jcestaro.CofrePadawan.Movimento;

import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;

import java.util.List;

public class Saque implements Movimento{

    @Override
    public void movimentar(Dinheiro dinheiro, List<Dinheiro> listaDinheiro) {
        listaDinheiro.remove(dinheiro);
    }
}
