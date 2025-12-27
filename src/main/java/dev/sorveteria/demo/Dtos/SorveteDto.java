package dev.sorveteria.demo.Dtos;

import java.math.BigDecimal;

import dev.sorveteria.demo.Enums.SorveteTipo;

public record SorveteDto (
    String descricao,
    BigDecimal preco,
    Integer quantidade,
    SorveteTipo tipo,
    Long saborId
) 
{}
