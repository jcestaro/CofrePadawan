package br.com.github.jcestaro.CofrePadawan;

import br.com.github.jcestaro.CofrePadawan.Enum.Cedula;
import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import br.com.github.jcestaro.CofrePadawan.Enum.Moeda;
import br.com.github.jcestaro.CofrePadawan.Movimento.Deposito;
import br.com.github.jcestaro.CofrePadawan.Movimento.Saque;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cofre {

    public List<Dinheiro> listaDinheiro = new ArrayList<>();
    public List<Dinheiro> opcoesMoedasECedulas = new ArrayList<>();
    Saque saque;
    Deposito deposito;

    public void deposita() {
        deposito = new Deposito();

        deposito.movimentar();
    }

    public List<Dinheiro> transformaOpcoesMoedasECedulasEmLista() {

        for (Moeda moeda : Moeda.values()) {
            opcoesMoedasECedulas.add(moeda);
        }

        for (Cedula cedula : Cedula.values()) {
            opcoesMoedasECedulas.add(cedula);
        }

        return opcoesMoedasECedulas;
    }

    public Optional<Dinheiro> validaCodigoDoDinheiro(int opcaoEscolhida){
        Optional<Dinheiro> valorEscolhido = opcoesMoedasECedulas.stream()
                .filter(opcao -> opcao.getCodigo() == opcaoEscolhida)
                .findFirst();

        return valorEscolhido;
    }
}