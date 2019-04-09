package br.com.github.jcestaro.CofrePadawan.Menu;

import br.com.github.jcestaro.CofrePadawan.Cofre;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        Collections.reverse(Cofre.getInstance().listaDinheiro);
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
