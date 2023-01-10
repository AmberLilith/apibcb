package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.Series;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaInadimplencia;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaMediaJuros;
import com.br.momento.aprendizado.momento.aprendizado.models.Taxas;
import com.br.momento.aprendizado.momento.aprendizado.services.TaxasService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-bcb/v2")
@CrossOrigin(origins = "*")
@Api(value="API REST - Consumindo API Dados Abertos Banco Central do Brasil")
public class TaxasController {

    @Autowired
    TaxasService taxasService;

    @GetMapping("{dataInicial}/{dataFinal}")
    @ApiOperation(value="Retorna relação de taxas (Média de Juros e Inadimplência) dentro do período informado (Data inicial e data final)")
    public ResponseEntity<List<Taxas>> obtemTaxas(@PathVariable String dataInicial, @PathVariable String dataFinal) throws JsonProcessingException {
        List<TaxaMediaJuros> taxaMediaJuros = taxasService.obtemTaxa(Series.TAXA_MEDIA_JUROS.getSerie(), dataInicial, dataFinal);
        List<TaxaInadimplencia> taxaInadimplencias = taxasService.obtemTaxa(Series.TAXA_INADIMPLENCIA.getSerie(), dataInicial, dataFinal);
        List<Taxas> taxas = Taxas.juntaTaxas(taxaMediaJuros, taxaInadimplencias);
        return new ResponseEntity<>(taxas, HttpStatus.OK);
    }

}
