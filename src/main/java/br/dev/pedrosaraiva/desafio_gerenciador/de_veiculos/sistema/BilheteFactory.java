package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.sistema;

import java.util.Calendar;
import java.util.Date;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.model.entity.Estabelecimento;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.Veiculo;

public class BilheteFactory {

    private Estabelecimento estabelecimento;
    private Veiculo veiculo;
    private Date entrada;
    private Date saida;


    public  BilheteFactory Estabelecimento(Estabelecimento estabelecimento){
        this.estabelecimento = estabelecimento;
        return this;
    }

    public BilheteFactory veiculo(Veiculo veiculo){
        this.veiculo = veiculo;
        return this;
    }

    public BilheteFactory entrada(Date entrada){
        this.entrada = entrada;
        return this;
    }

    public BilheteFactory saida(Date saida){
        this.saida = saida;
        return this;
    }

    public Bilhete GerarBilhete(){
        Bilhete bilhete = new Bilhete();
        bilhete.setEstabelecimento(this.estabelecimento);
        bilhete.setEntrada(entrada);
        bilhete.setVeiculo(veiculo);
        bilhete.setSaida(saida);
        return bilhete;
    }

}
