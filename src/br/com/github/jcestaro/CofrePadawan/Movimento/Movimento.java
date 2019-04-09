package br.com.github.jcestaro.CofrePadawan.Movimento;


import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;

import java.util.List;

public interface Movimento  {

    void movimentar(Dinheiro valor, List<Dinheiro> listaDinheiro);

}
