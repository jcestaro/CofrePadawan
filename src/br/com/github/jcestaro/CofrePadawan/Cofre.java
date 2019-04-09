package br.com.github.jcestaro.CofrePadawan;

import br.com.github.jcestaro.CofrePadawan.Enum.Cedula;
import br.com.github.jcestaro.CofrePadawan.Enum.Dinheiro;
import br.com.github.jcestaro.CofrePadawan.Enum.Moeda;
import br.com.github.jcestaro.CofrePadawan.Menu.Menu;
import br.com.github.jcestaro.CofrePadawan.Menu.Opcao;
import br.com.github.jcestaro.CofrePadawan.Movimento.Deposito;
import br.com.github.jcestaro.CofrePadawan.Movimento.Saque;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cofre {

    private static Cofre singletonCofre = null;
    public List<Dinheiro> listaDinheiro = new ArrayList<>();
    public List<Dinheiro> opcoesMoedasECedulas;
    private Dinheiro valorEscolhido;
    private Opcao opcaoMenuEscolhida;
    private BigDecimal saldoTotal;
    private Saque saque;
    private Deposito deposito;
    private Menu menu = new Menu();

    private Cofre() {}

    public static Cofre getInstance()
    {
        if (singletonCofre == null)
            singletonCofre = new Cofre();

        return singletonCofre;
    }


    public void exibeMenuPrincipal () {
        menu.montaMenu();
        System.out.println(menu);
    }

    public void deposita(Dinheiro dinheiro) {
        this.deposito = new Deposito();

        this.deposito.movimentar(dinheiro, this.listaDinheiro);

        System.out.println("Valor depositado com sucesso!");
    }

    public void saca(Dinheiro dinheiro){
        this.saque = new Saque();

        this.saque.movimentar(dinheiro, this.listaDinheiro);

        System.out.println("Valor sacado com sucesso!");
    }

    public void saca(BigDecimal valor){
        this.saque = new Saque();

        this.saque.movimentar((Dinheiro) valor, this.listaDinheiro);

        System.out.println("Valor sacado com sucesso!");
    }


    public List<Dinheiro> transformaOpcoesMoedasECedulasEmLista() {
        opcoesMoedasECedulas = new ArrayList<>();

        for (Moeda moeda : Moeda.values()) {
            this.opcoesMoedasECedulas.add(moeda);
        }

        for (Cedula cedula : Cedula.values()) {
            this.opcoesMoedasECedulas.add(cedula);
        }

        return this.opcoesMoedasECedulas;
    }

    public Dinheiro validaCodigoDoDinheiro(int opcaoEscolhida){
        this.valorEscolhido = opcoesMoedasECedulas.stream()
                .filter(opcao -> opcao.getCodigo() == opcaoEscolhida)
                .findFirst()
                .get();

        return this.valorEscolhido;
    }

    public Opcao validaOpcaoDoMenu (int opcaoEscolhida) {
         this.opcaoMenuEscolhida = menu.listaOpcoes.stream()
                .filter(opcao -> opcao.getCodigo() == opcaoEscolhida)
                .findFirst()
                .get();

         return opcaoMenuEscolhida;
    }

    public BigDecimal buscarSaldoTotal() {
        saldoTotal = new BigDecimal(0);

        for (Dinheiro dinheiro : listaDinheiro){
            saldoTotal = saldoTotal.add(dinheiro.getValor());
        }

        return saldoTotal;
    }
}