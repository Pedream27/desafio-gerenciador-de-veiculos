package br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.entity;

import br.dev.pedrosaraiva.desafio_gerenciador.de_veiculos.veiculo.model.dto.VeiculoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbVeiculos")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private String placa;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String tipo;

    public Veiculo (VeiculoDTO veiculo){
        marca = veiculo.marca();
        modelo = veiculo.modelo();
        cor = veiculo.cor();
        placa = veiculo.placa();
        tipo = veiculo.tipo();
    }

}
