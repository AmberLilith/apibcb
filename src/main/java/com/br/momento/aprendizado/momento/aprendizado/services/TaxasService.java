package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.TaxaFactory;
import com.br.momento.aprendizado.momento.aprendizado.TaxaFeign;
import com.br.momento.aprendizado.momento.aprendizado.models.Taxa;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxasService {

    @Autowired
    private TaxaFeign taxaFeign;

    public List<?> obtemTaxa(String serie, String dataInicial, String dataFinal){
       List<Taxa> taxa = taxaFeign.obtemJsonTaxa(serie, dataInicial, dataFinal);
        return TaxaFactory.convertToTaxSerieList(taxa, serie);
    }
}
