package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.models.TaxaInadimplencia;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaMediaJuros;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxasMediaJurosMaisTaxasInadimplencia;
import com.br.momento.aprendizado.momento.aprendizado.services.TaxaMediaJurosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TaxaMediaJurosController {

    @Autowired
    TaxaMediaJurosService taxaMediaJurosService;

    /*@GetMapping()
    public ResponseEntity<Object[]> obtemTaxaMediaJuros(@RequestParam String dataInicial, @RequestParam String dataFinal){
        TaxaMediaJuros[] taxaMediaJuros =  taxaMediaJurosService.obtemTaxaMediaJuros(dataInicial, dataFinal);
        TaxaInadimplencia[] taxaInadimplencias =  taxaMediaJurosService.obtemTaxasInadimplencia(dataInicial, dataFinal);
        Object[] mergedArrays = Merger.mergerArraySameLength(taxaMediaJuros, taxaInadimplencias);
        return new ResponseEntity<>(mergedArrays, HttpStatus.OK);
    }*/

    @GetMapping()
    public ResponseEntity<TaxasMediaJurosMaisTaxasInadimplencia[]> obtemTaxaMediaJuros(@RequestParam String dataInicial, @RequestParam String dataFinal){
        TaxaMediaJuros[] taxaMediaJuros =  taxaMediaJurosService.obtemTaxaMediaJuros(dataInicial, dataFinal);
        TaxaInadimplencia[] taxaInadimplencias =  taxaMediaJurosService.obtemTaxasInadimplencia(dataInicial, dataFinal);
        TaxasMediaJurosMaisTaxasInadimplencia[] taxasMediaJurosMaisTaxasInadimplencia = TaxasMediaJurosMaisTaxasInadimplencia.juntaTaxas(taxaMediaJuros, taxaInadimplencias);
        return new ResponseEntity<>(taxasMediaJurosMaisTaxasInadimplencia, HttpStatus.OK);
    }
}
