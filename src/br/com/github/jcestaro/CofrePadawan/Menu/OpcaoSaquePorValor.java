package br.com.github.jcestaro.CofrePadawan.Menu;

import br.com.github.jcestaro.CofrePadawan.Cofre;
import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import java.math.BigDecimal;
import java.util.*;

public class OpcaoSaquePorValor implements Opcao {

    private final int codigo = 3;
    private final String descricao = "Saque por valor";
    List<Dinheiro> listaDinheiroSaque;

    @Override
    public void disparaAcao() {
        boolean temDinheiroNoCofre = verificaSeTemDinheiroNoCofre();
        if (temDinheiroNoCofre){
            verificaSeTemSaldoParaSacarESaca(pegaValorInformado());
        }
    }

    private  boolean verificaSeTemDinheiroNoCofre () {
        BigDecimal saldoTotal = Cofre.getInstance().buscarSaldoTotal();

        if (saldoTotal.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Não é possível sacar, o cofre está vazio!" + System.lineSeparator());
            return false;
        }
        return true;
    }

    private void verificaSeTemSaldoParaSacarESaca(BigDecimal valorSaque) {
        BigDecimal saldoTotal = Cofre.getInstance().buscarSaldoTotal();

        if (saldoTotal.compareTo(valorSaque) == -1) {
            System.out.println("Não é possível sacar " + valorSaque + ", pois o saldo atual é: " + saldoTotal);
            verificaSeTemSaldoParaSacarESaca(pegaValorInformado());
        } else {
            sacar(valorSaque);
        }
    }


    private void verificaSeTemCedulaMoedaDisponivelParaOValorDoSaque (BigDecimal valorSaque) {
        BigDecimal valorSaqueComparacao = valorSaque;
        for (Dinheiro dinheiro : Cofre.getInstance().listaDinheiro) {
            if (valorSaqueComparacao.compareTo(dinheiro.getValor()) > -1) {
                valorSaqueComparacao = valorSaqueComparacao.subtract(dinheiro.getValor());
            }
        }
        if(valorSaqueComparacao.compareTo(BigDecimal.ZERO) > 0){
            System.out.println("Não é possível fazer o saque, verifique a lista de cédulas e veja quais são os possíveis saques!");
            System.out.println("O cofre possui notas/moedas de: " + System.lineSeparator());
            Cofre.getInstance().listaDinheiro.forEach(dinheiro -> System.out.println(dinheiro.getDescricao() + System.lineSeparator()));
            verificaSeTemSaldoParaSacarESaca(pegaValorInformado());
        }
    }

    private void ordenaListaDinheiroDoMaiorParaOMenor () {
        Cofre.getInstance().listaDinheiro.sort((dinheiro1, dinheiro2) -> dinheiro2.getValor().compareTo(dinheiro1.getValor()));
    }

    private void sacar (BigDecimal valorSaque) {
        listaDinheiroSaque = new ArrayList<>();

        ordenaListaDinheiroDoMaiorParaOMenor();
        verificaSeTemCedulaMoedaDisponivelParaOValorDoSaque(valorSaque);
        adicionarDinheiroNaListaDeSaque(valorSaque);
        removeDinheiroDaListaDoCofre();
    }

    private void removeDinheiroDaListaDoCofre () {
        for (Dinheiro dinheiro : listaDinheiroSaque) {
            Cofre.getInstance().listaDinheiro.remove(dinheiro);
        }

        System.out.println("Saque efetuado com sucesso, pegue o seu dinheiro!");
        System.out.println(listaDinheiroSaque);
    }

    private void adicionarDinheiroNaListaDeSaque (BigDecimal valorSaque) {
        for (Dinheiro dinheiro : Cofre.getInstance().listaDinheiro) {
            if(valorSaque.compareTo(dinheiro.getValor()) > -1){
                listaDinheiroSaque.add(dinheiro);
                valorSaque = valorSaque.subtract(dinheiro.getValor());
            }
            if(valorSaque.compareTo(BigDecimal.ZERO) == 0){
                break;
            }
        }
    }

    private BigDecimal pegaValorInformado() {
        System.out.println("Digite o valor a ser sacado: ");

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
