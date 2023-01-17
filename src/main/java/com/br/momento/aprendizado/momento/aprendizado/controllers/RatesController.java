package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.Series;
import com.br.momento.aprendizado.momento.aprendizado.models.AllRates;
import com.br.momento.aprendizado.momento.aprendizado.services.RatesService;
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
public class RatesController {

    @Autowired
    RatesService taxasService;

    @GetMapping("{initialDate}/{finalDate}")
    @ApiOperation(value="Retorna relação de taxas (Média de Juros e Inadimplência) dentro do período informado (Data inicial e data final)")
    public ResponseEntity<List<AllRates>> getRates(@PathVariable String initialDate, @PathVariable String finalDate){
        List<?> taxaMediaJuros = taxasService.getRates(Series.AVERAGE_INTEREST_RATE.getSerie(), initialDate, finalDate);
        List<?> taxaInadimplencias = taxasService.getRates(Series.DEFAULT_RATE.getSerie(), initialDate, finalDate);
        List<AllRates> taxas = AllRates.joinRates(taxaMediaJuros, taxaInadimplencias);
        return new ResponseEntity<>(taxas, HttpStatus.OK);
    }

    /*@PostMapping("{dataInicial}/{dataFinal}")
    @ApiOperation(value="Retorna relação de taxas todas as taxas informadas no body da requisição dentro do período informado (Data inicial e data final)")
    public ResponseEntity<List<AllRates>> obtemXTaxas(@PathVariable String dataInicial, @PathVariable String dataFinal){
        List<?> taxaMediaJuros = taxasService.getRates(Series.AVERAGE_INTEREST_RATE.getSerie(), dataInicial, dataFinal);
        List<?> taxaInadimplencias = taxasService.getRates(Series.DEFAULT_RATE.getSerie(), dataInicial, dataFinal);
        List<AllRates> taxas = AllRates.joinRates(taxaMediaJuros, taxaInadimplencias);
        return new ResponseEntity<>(taxas, HttpStatus.OK);
    }*/

}
