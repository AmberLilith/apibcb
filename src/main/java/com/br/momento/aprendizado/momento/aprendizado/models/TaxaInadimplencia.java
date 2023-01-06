package com.br.momento.aprendizado.momento.aprendizado.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxaInadimplencia {

    private String data;

    @JsonAlias({ "valor" })
    private Double taxaInadimplencia;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getTaxaInadimplencia() {
        return taxaInadimplencia;
    }

    public void setTaxaInadimplencia(Double taxaInadimplencia) {
        this.taxaInadimplencia = taxaInadimplencia;
    }
}
