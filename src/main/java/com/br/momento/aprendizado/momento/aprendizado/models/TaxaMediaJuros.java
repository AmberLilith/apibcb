package com.br.momento.aprendizado.momento.aprendizado.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class TaxaMediaJuros{

    private String data;

    @JsonAlias({"valor"})
    private Double taxaMediaJuros;

}
