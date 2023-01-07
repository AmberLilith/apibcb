package com.br.momento.aprendizado.momento.aprendizado.models;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Taxas {

    private String data;

    private Double taxaMediaJuros;

    private Double taxaInadimplencia;

    public static List<Taxas> juntaTaxas(List<TaxaMediaJuros> taxaMediaJuros, List<TaxaInadimplencia> taxaInadimplencias) {
        List<Taxas> taxasList = new ArrayList<>();
        Iterator<TaxaMediaJuros> taxaMediaJurosIterator = taxaMediaJuros.iterator();
        Iterator<TaxaInadimplencia> taxaInadimplenciaIterator = taxaInadimplencias.iterator();

        while (taxaMediaJurosIterator.hasNext() && taxaInadimplenciaIterator.hasNext()) {
            Taxas taxas = new Taxas();
            BeanUtils.copyProperties(taxaMediaJurosIterator.next(), taxas);
            BeanUtils.copyProperties(taxaInadimplenciaIterator.next(), taxas);
            taxasList.add(taxas);
        }

        return taxasList;
    }

}

