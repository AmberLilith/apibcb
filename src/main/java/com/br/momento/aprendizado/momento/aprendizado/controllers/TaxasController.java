package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.models.TaxaInadimplencia;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaMediaJuros;
import com.br.momento.aprendizado.momento.aprendizado.models.Taxas;
import com.br.momento.aprendizado.momento.aprendizado.services.TaxasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-bcb/v1")
@CrossOrigin(origins = "*")
@Api(value="API REST - Consumindo API Dados Abertos Banco Central do Brasil")
public class TaxasController {

    @Autowired
    TaxasService taxasService;

    @GetMapping()
    @ApiOperation(value="Retorna relação de taxas do últimos 11 anos e 8 meses")
    public ResponseEntity<List<Taxas>> obtemTaxasUltimosOnzeAnos() {
        List<TaxaMediaJuros> taxaMediaJuros = taxasService.obtemTaxaMediaJurosUltimosOnzeAnos();
        List<TaxaInadimplencia> taxaInadimplencias = taxasService.obtemTaxasInadimplenciaUltimosOnzeAnos();
        List<Taxas> taxas = Taxas.juntaTaxas(taxaMediaJuros, taxaInadimplencias);
        return new ResponseEntity<>(taxas, HttpStatus.OK);
    }

    @GetMapping("/{dataInicial}/{dataFinal}")
    @ApiOperation(value="Retorna relação de taxas dentro do período informado (Data inicial e data final)")
    public ResponseEntity<List<Taxas>> obtemTaxasPorPeriodo(@PathVariable String dataInicial, @PathVariable String dataFinal) {
        List<TaxaMediaJuros> taxaMediaJuros = taxasService.obtemTaxaMediaJurosPorPeriodo(dataInicial, dataFinal);
        List<TaxaInadimplencia> taxaInadimplencias = taxasService.obtemTaxasInadimplenciaPorPeriodo(dataInicial, dataFinal);
        List<Taxas> taxas = Taxas.juntaTaxas(taxaMediaJuros, taxaInadimplencias);
        return new ResponseEntity<>(taxas, HttpStatus.OK);
    }

    @GetMapping("/{quantidadeMeses}")
    @ApiOperation(value="Retorna relação de taxas do últimos meses informados em {quantidadeMeses}")
    public ResponseEntity<List<Taxas>> obtemTaxasPorQuantidadeMeses(@PathVariable Integer quantidadeMeses) {
        List<TaxaMediaJuros> taxaMediaJuros = taxasService.obtemTaxaMediaJurosPorQuantidadeMeses(quantidadeMeses);
        List<TaxaInadimplencia> taxaInadimplencias = taxasService.obtemTaxasInadimplenciaPorQuantidadeMeses(quantidadeMeses);
        List<Taxas> taxas = Taxas.juntaTaxas(taxaMediaJuros, taxaInadimplencias);
        return new ResponseEntity<>(taxas, HttpStatus.OK);
    }

}
