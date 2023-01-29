package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.SerieFeign;
import com.br.momento.aprendizado.momento.aprendizado.exceptions.EmptyListException;
import com.br.momento.aprendizado.momento.aprendizado.helpers.SerieMockFactory;
import com.br.momento.aprendizado.momento.aprendizado.models.Serie;
import com.br.momento.aprendizado.momento.aprendizado.models.Series;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class SerieServiceTest {

    @MockBean
    SerieFeign serieFeign;

    @Autowired
    SerieServiceImpl service;

    @Test
    @DisplayName("Quando solicitar series, uma lista de Series")
    void when_requestSeries_returnListOfSeries(){
        //given
        List<Serie> serieList = SerieMockFactory.createListOfSerie();
        Mockito.when(serieFeign.getSerie(any(String.class), any(String.class), any(String.class))).thenReturn(serieList);

        //when
        List<Series> response = service.getSeries("x","y");

        //then
        Assertions.assertEquals(response.size(), 3);
    }

    @Test
    @DisplayName("Quando solicitar series e uma lista for vazia, lançar EmptyListException")
    void when_requestSeries_and_someListOfSerieIsEmpty_thenThrowEmptyListException(){
        //given
        Mockito.when(serieFeign.getSerie(any(String.class), any(String.class), any(String.class))).thenThrow(new EmptyListException(""));

        //when then
        Assertions.assertThrows(EmptyListException.class, () -> service.getSeries("x","y"));
    }

    @Test
    @DisplayName("Ao tentar converter para Lista de Series e alguma lista de Serie for vazia, lançar EmptyListException")
    void when_convertIntoListOfSeries_and_someListOfSerieIsEmpty_thenThrowEmptyListException(){
        //given when then
        Assertions.assertThrows(EmptyListException.class, () -> SerieServiceImpl.convertToListOfSeries(new ArrayList<>(), new ArrayList<>()));
    }
}





