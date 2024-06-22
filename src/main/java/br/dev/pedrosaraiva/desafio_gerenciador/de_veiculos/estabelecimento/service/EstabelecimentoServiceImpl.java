package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.model.entity.Estabelecimento;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.repository.EstabeleciementoRepository;
import jakarta.validation.Valid;

@Service
public class EstabelecimentoServiceImpl implements IEstabelecimentoService {

    @Autowired
    private EstabeleciementoRepository _Repository;

    @Override
    public List<Estabelecimento> buscarTodos() {
        return _Repository.findAll();
    }

    @Override
    public Optional<Estabelecimento> buscarPorId(Long id) {
        Optional<Estabelecimento> possivelEstabelecimento = _Repository.findById(id);
        if (!possivelEstabelecimento.isPresent()) {
            throw new RuntimeException("Estabelecimento não foi encontrado ");
        }
        return possivelEstabelecimento;
    }

    @Override
    public Estabelecimento criarEstabelecimento(@Valid Estabelecimento estabelecimento) {
        return _Repository.save(estabelecimento);
    }

    @Override
    public Estabelecimento AtualizarEstabelecimento(Long id, Estabelecimento estabelecimento) {
       Optional<Estabelecimento> possivelEstabelecimento = _Repository.findById(id);
       if (!possivelEstabelecimento.isPresent()) {
        throw new RuntimeException("Erro : Não foi possivel atualizar o estabelecimento pois o mesmo não foi encontrado ");
       }
       _Repository.delete(possivelEstabelecimento.get());
       return _Repository.save(estabelecimento);

    }

    @Override
    public void deleteEstabelecimento(Long id) {
         _Repository.deleteById(id);
    }

}
