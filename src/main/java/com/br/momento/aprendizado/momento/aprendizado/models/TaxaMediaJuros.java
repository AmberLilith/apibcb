package com.br.momento.aprendizado.momento.aprendizado.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaxaMediaJuros{

    private String data;

    @JsonAlias({"valor"})
    private Double taxaMediaJuros;

}
