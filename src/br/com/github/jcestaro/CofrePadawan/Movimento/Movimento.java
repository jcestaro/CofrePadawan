package br.com.github.jcestaro.CofrePadawan.Movimento;

import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import java.util.List;

public interface Movimento  {

    default void movimentar(Dinheiro valor, List<Dinheiro> listaDinheiro) {

        if (ehDeposito()){
            depositar(valor, listaDinheiro);
        } else {
            sacar(valor, listaDinheiro);
        }
    }

    boolean ehDeposito();
    void sacar (Dinheiro valor, List<Dinheiro> listaDinheiro);
    void depositar (Dinheiro valor, List<Dinheiro> listaDinheiro);

}
