package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.service;

import java.util.List;
import java.util.Optional;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.Veiculo;

public interface IVeiculoService {

    List<Veiculo> buscarTodos();

    Veiculo buscarPorId(Long id);

    Veiculo criarEstabelecimento(Veiculo veiculo);

    Veiculo AtualizarVeiculo(Long id, Veiculo veiculo);

    void deleteVeiculo(Long id);
}
