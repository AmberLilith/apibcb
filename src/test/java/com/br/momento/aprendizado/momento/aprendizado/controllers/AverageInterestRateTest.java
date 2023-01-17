package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.RateFeign;
import com.br.momento.aprendizado.momento.aprendizado.helpers.RateMockFactory;
import com.br.momento.aprendizado.momento.aprendizado.models.Rate;
import com.br.momento.aprendizado.momento.aprendizado.services.RatesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AverageInterestRateTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RatesService ratesService;

    @MockBean
    private RateFeign rateFeign;


    @Test
    @DisplayName("")
    public void test() throws Exception {
        /*List<Rate> rates = RateMockFactory.createListOfRate();
        List<?> averageInterestRates = RateMockFactory.createListOfAverageInterestRate();
        //Mockito.doReturn(averageInterestRates).when(ratesService.getRates("x", "y","z"));
        Mockito.when(ratesService.getRates("x", "y","z")).thenReturn(averageInterestRates);
        this.mockMvc
                .perform(
                        get("/api-bcb/v2/01-01-2022/01-02-2022")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new ObjectMapper().writeValueAsString(rates))
                                .accept(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isOk());*/
    }

    }

