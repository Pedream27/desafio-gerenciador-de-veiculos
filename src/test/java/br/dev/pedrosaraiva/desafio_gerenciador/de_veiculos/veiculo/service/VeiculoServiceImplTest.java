package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.dto.VeiculoDTO;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.TipoVeiculo;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.Veiculo;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.repository.VeiculoRepository;
import jakarta.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class VeiculoServiceImplTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private VeiculoRepository _Repository;



    @Test
    void testAtualizarVeiculo() {

    }

    @Test
    void testBuscarPorId() {
        Long id = 1L;
        VeiculoDTO veiculo = new VeiculoDTO(2L,"Preta", "BMW", "M2", "OW54T7", "TipoVeiculo.Carro");
        this.createVeiculo(veiculo);
        Optional<Veiculo> possivelVeiculo = this._Repository.findById(id);
        assertThat(possivelVeiculo.isPresent()).isTrue();

    }

    private Veiculo createVeiculo(VeiculoDTO veiculo) {
        Veiculo newVeiculo = new Veiculo(veiculo);
       this.entityManager.persist(newVeiculo);
        return newVeiculo;
    }

    @Test
    void testBuscarTodos() {

    }

    @Test
    void testCriarEstabelecimento() {

    }

    @Test
    void testDeleteVeiculo() {

    }
}
