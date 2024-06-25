package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.sistema;

import java.util.Calendar;
import java.util.Date;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.estabelecimento.model.entity.Estabelecimento;
import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity.Veiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "tb_bilhete")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bilhete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Estabelecimento estabelecimento;
    private Veiculo veiculo;
    private Date entrada;
    private Date saida;



}
