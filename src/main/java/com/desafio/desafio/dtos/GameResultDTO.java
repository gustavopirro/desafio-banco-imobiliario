package com.desafio.desafio.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameResultDTO {
    private int quantidadeDeRodadas;
    private String vencedor;
    private int quantidadeDePropriedadesDoVencedor;
    private List<String> jogadores;
}
