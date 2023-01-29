package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.exceptions.EmptyListException;
import com.br.momento.aprendizado.momento.aprendizado.helpers.SerieMockFactory;
import com.br.momento.aprendizado.momento.aprendizado.models.Serie;
import com.br.momento.aprendizado.momento.aprendizado.models.Series;
import com.br.momento.aprendizado.momento.aprendizado.services.SerieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc()
 class SerieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SerieServiceImpl serieService;


    @Test
    @DisplayName("Quando solicitar series, retornar status code 200 e uma lista de Series")
     void when_requestSeries_returnStatusCode200AndListOfSeries() throws Exception {
        List<Serie> serieList = SerieMockFactory.createListOfSerie();
        List<Series> seriesList = SerieMockFactory.createListOfSeries();
        Mockito.when(serieService.getSeries(any(String.class), any(String.class))).thenReturn(seriesList);
        this.mockMvc
                .perform(
                        get("/api-bcb/v2/01-01-2022/01-03-2022")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new ObjectMapper().writeValueAsString(serieList))
                                .accept(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].averageInterestRate").value("6.5"));

    }

    @Test
    @DisplayName("Quando solicitar series e returnar alguma lista vazia,  retornar status code 404")
    void when_requestSeries_and_someSerieIsEmpty_returnStatusCode404AndListOfSeries() throws Exception {
        List<Serie> serieList = new ArrayList<>();
        Mockito.when(serieService.getSeries(any(String.class), any(String.class))).thenThrow( new EmptyListException("Uma das listas de série está vazia!"));
        this.mockMvc
                .perform(
                        get("/api-bcb/v2/01-01-2022/01-03-2022")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new ObjectMapper().writeValueAsString(serieList))
                                .accept(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.list").value("Uma das listas de série está vazia!"));

    }

    }

