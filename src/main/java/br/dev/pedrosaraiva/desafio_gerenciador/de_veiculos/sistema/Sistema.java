package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.sistema;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

import org.hibernate.engine.profile.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.model.entity.Estabelecimento;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.TipoVeiculo;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.Veiculo;

@Service
public class Sistema {

    private Estabelecimento estabelecimento;

    @Autowired
    private BilheteRepository BilheteRepository;

    private Integer vagasMotos;
    private Integer vagasCarro;
    private BilheteFactory bilhete;

    public Bilhete entradaDeVeiculo(Veiculo veiculo) {
        Calendar calendar = Calendar.getInstance();
        if (veiculo.getTipo().equals(TipoVeiculo.Carro)) {
            if (vagasCarro == 0) {
                throw new RuntimeException("Estacionamento cheio");
            }
            vagasCarro--;
        }
        if (veiculo.getTipo().equals(TipoVeiculo.Moto)) {
            if (vagasMotos == 0) {
                throw new RuntimeException("Estacionamento cheio");
            }
            vagasMotos--;
        }
        Bilhete novoBilhete = bilhete
                .Estabelecimento(this.estabelecimento)
                .entrada(calendar.getTime())
                .saida(null)
                .GerarBilhete();
        BilheteRepository.save(novoBilhete);

        return novoBilhete;

    }

    public Bilhete saidaDeVeiculo(Veiculo veiculo) {
        Calendar calendar = Calendar.getInstance();
        Optional<Bilhete> possivelBilhete = BilheteRepository.findByVeiculo(veiculo);
        Bilhete utilBilhete;
        if (possivelBilhete.isPresent()) {
            utilBilhete = possivelBilhete.get();
            utilBilhete.setSaida(calendar.getTime());
            Veiculo utilVeiculo = utilBilhete.getVeiculo();
            if (utilVeiculo.getTipo().equals(TipoVeiculo.Moto)) {
                vagasMotos++;
            } else if (utilVeiculo.getTipo().equals(TipoVeiculo.Carro)) {
                vagasCarro++;
            }
        } else {
            throw new RuntimeException("Bilhete não encontrado");
        }

        return utilBilhete;
    }


    public List<Bilhete> gerarRelatorio(){
        
        return BilheteRepository.findAll();
    }
}
