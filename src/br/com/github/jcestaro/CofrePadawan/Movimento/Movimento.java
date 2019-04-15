package br.com.github.jcestaro.CofrePadawan.Movimento;

import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import java.util.List;

public abstract class  Movimento  {

    abstract void movimentar(Dinheiro valor, List<Dinheiro> listaDinheiro);

}
