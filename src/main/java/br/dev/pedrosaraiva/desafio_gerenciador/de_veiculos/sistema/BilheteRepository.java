package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.sistema;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.Veiculo;


public interface BilheteRepository extends JpaRepository<Bilhete,Long> {
    Optional<Bilhete> findByVeiculo(Veiculo veiculo);
}
