package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.Veiculo;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.repository.VeiculoRepository;
@Service
public class VeiculoServiceImpl implements IVeiculoService {

    @Autowired
    private VeiculoRepository _Repository;

    @Override
    public List<Veiculo> buscarTodos() {
        return _Repository.findAll();
    }

    @Override
    public Veiculo buscarPorId(Long id) {
        Optional<Veiculo> possivelVeiculo = _Repository.findById(id);
        if (possivelVeiculo.isEmpty()) {
            throw new RuntimeException("Veiculo não encontrado");
        }
        return possivelVeiculo.get();
    }

    @Override
    public Veiculo criarEstabelecimento(Veiculo veiculo) {
        return _Repository.save(veiculo);
    }

    @Override
    public Veiculo AtualizarVeiculo(Long id, Veiculo veiculo) {
        Optional<Veiculo> possivelVeiculo = _Repository.findById(id);
        if (possivelVeiculo.isEmpty()) {
            throw new RuntimeException("Veiculo não encontrado");
        }
        _Repository.deleteById(id);
        return _Repository.save(veiculo);

    }

    @Override
    public void deleteVeiculo(Long id) {
        _Repository.deleteById(id);
    }

}
