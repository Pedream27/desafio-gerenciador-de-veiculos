package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.service;

import java.util.List;
import java.util.Optional;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.model.entity.Estabelecimento;

public interface IEstabelecimentoService {

    List<Estabelecimento> buscarTodos();

    Optional<Estabelecimento> buscarPorId(Long id);

    Estabelecimento criarEstabelecimento(Estabelecimento estabelecimento);

    Estabelecimento AtualizarEstabelecimento(Long id, Estabelecimento estabelecimento);

    void deleteEstabelecimento(Long id);
}
