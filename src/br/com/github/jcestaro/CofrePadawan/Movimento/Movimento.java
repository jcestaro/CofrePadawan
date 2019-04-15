package br.com.github.jcestaro.CofrePadawan.Movimento;

import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import java.util.List;

public abstract class  Movimento  {

    public void movimentar (Dinheiro valor, List<Dinheiro> listaDinheiro) {

        if (ehDeposito()){
            depositar(valor, listaDinheiro);
        } else {
            sacar(valor, listaDinheiro);
        }
    }

    public abstract boolean ehDeposito();
    public abstract void sacar (Dinheiro valor, List<Dinheiro> listaDinheiro);
    public abstract void depositar (Dinheiro valor, List<Dinheiro> listaDinheiro);


}
