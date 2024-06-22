package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity;


public enum TipoVeiculo {
    Carro("CARRO"),
    Moto ("MOTO");

    private String tipo;

    TipoVeiculo( String tipo){
        this.tipo = tipo;
    }
}
