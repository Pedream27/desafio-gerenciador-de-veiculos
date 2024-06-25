package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.dto;

import java.util.Optional;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.TipoVeiculo;

public record VeiculoDTO(
    Long id,
    String cor,
    String marca,
    String modelo,
    String placa,
    String tipo
) {

}
