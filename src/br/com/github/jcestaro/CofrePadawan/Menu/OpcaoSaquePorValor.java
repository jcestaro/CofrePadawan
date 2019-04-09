package br.com.github.jcestaro.CofrePadawan.Menu;

import br.com.github.jcestaro.CofrePadawan.Cofre;
import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Collections.reverse;

public class OpcaoSaquePorValor implements Opcao {

    private final int codigo = 3;
    private final String descricao = "Saque por valor";

    @Override
    public void disparaAcao() {
        pedeValorParaUsuario();
        verificaSeTemSaldo(pegaValorInformado());
    }

    private void verificaSeTemSaldo (BigDecimal valorSaque) {
        BigDecimal saldoTotal = Cofre.getInstance().buscarSaldoTotal();
        if (saldoTotal.compareTo(valorSaque) == -1) {
            System.out.println("Não é possível sacar " + valorSaque + ", pois o saldo atual é: " + saldoTotal);
            pedeValorParaUsuario();
            verificaSeTemSaldo(pegaValorInformado());
        } else {
            sacar(valorSaque);
        }
    }

    private void sacar (BigDecimal valorSaque) {

        //reordenando a lista de dinheiro do maior para o menor valor
        Cofre.getInstance().listaDinheiro.sort((o1, o2) -> o2.getValor().compareTo(o1.getValor()));
        //Cofre.getInstance().listaDinheiro.sort(Comparator.comparing(Dinheiro::getValor).reversed());

        //verificando se tem como fazer o saque com o dinheiro que foi depositado
        //soma o valor do saque
        BigDecimal valorSaqueComparacao = valorSaque;
        for (Dinheiro dinheiro : Cofre.getInstance().listaDinheiro) {
            if (valorSaqueComparacao.compareTo(dinheiro.getValor()) > -1) {
                valorSaqueComparacao = valorSaqueComparacao.subtract(dinheiro.getValor());
            }
        }
        //verifica se vai sobrar valor do saque
        if(valorSaqueComparacao.compareTo(BigDecimal.ZERO) > 0){
            System.out.println("Não é possível fazer o saque, verifique a lista de cédulas e veja quais são os possíveis saques!");
            System.out.println(Cofre.getInstance().listaDinheiro);
            pedeValorParaUsuario();
            verificaSeTemSaldo(pegaValorInformado());
        }

        //cria uma lista para exibir depois quais serão os valores em dinheiro do saque
        List<Dinheiro> listaDinheiroSaque = new ArrayList<>();
        for (Dinheiro dinheiro : Cofre.getInstance().listaDinheiro) {
            if(valorSaque.compareTo(dinheiro.getValor()) > -1){
                listaDinheiroSaque.add(dinheiro);
                valorSaque = valorSaque.subtract(dinheiro.getValor());
            }
            if(valorSaque.compareTo(BigDecimal.ZERO) == 0){
                break;
            }
        }

        //exclui os dinheiros encontrados para saque
        for (Dinheiro dinheiro : listaDinheiroSaque) {
            Cofre.getInstance().listaDinheiro.remove(dinheiro);
        }

        //mostra qual o saque
        System.out.println("Saque efetuado com sucesso, pegue o seu dinheiro!");
        System.out.println(listaDinheiroSaque);

    }

    private void pedeValorParaUsuario () {
        System.out.println("Digite o valor a ser sacado: ");
    }

    private BigDecimal pegaValorInformado() {
        Scanner scanner = new Scanner(System.in);
        try {
            BigDecimal valorInformado = scanner.nextBigDecimal();
            return valorInformado;

        } catch (InputMismatchException ex) {
            System.out.println("Valor informado inválido, por favor insira um valor válido.");
            return pegaValorInformado();
        }
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
