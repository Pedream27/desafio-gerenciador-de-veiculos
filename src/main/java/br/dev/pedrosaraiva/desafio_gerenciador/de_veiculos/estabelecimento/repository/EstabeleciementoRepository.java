package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.model.entity.Estabelecimento;

public interface EstabeleciementoRepository extends JpaRepository<Estabelecimento, Long> {
    
}
