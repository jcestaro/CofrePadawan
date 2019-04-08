package br.com.github.jcestaro.CofrePadawan;

import br.com.github.jcestaro.CofrePadawan.Enum.Cedula;
import br.com.github.jcestaro.CofrePadawan.Enum.Moeda;
import br.com.github.jcestaro.CofrePadawan.Interface.Deposito;
import br.com.github.jcestaro.CofrePadawan.Interface.Saque;

import java.util.ArrayList;
import java.util.List;

public class Cofre {

    List<Moeda> listaMoeda = new ArrayList<>();
    List<Cedula> listaCedula = new ArrayList<>();
    Saque saque;
    Deposito deposito;



}