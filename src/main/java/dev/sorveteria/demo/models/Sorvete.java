package dev.sorveteria.demo.models;

import java.math.BigDecimal;

import dev.sorveteria.demo.Enums.SorveteTipo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sorvete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Integer quantidade;
    private BigDecimal preco;
    private SorveteTipo tipo;
}    
    
