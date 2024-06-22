package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.TipoVeiculo;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {
    List<Veiculo> findByTipo(TipoVeiculo tipo);
}
