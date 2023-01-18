package com.br.momento.aprendizado.momento.aprendizado.controllers;

import com.br.momento.aprendizado.momento.aprendizado.SerieFeign;
import com.br.momento.aprendizado.momento.aprendizado.services.SeriesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
public class AverageInterestRateTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SeriesService ratesService;

    @MockBean
    private SerieFeign rateFeign;


    @Test
    @DisplayName("")
    public void test() throws Exception {
        /*List<SerieRate> rates = RateMockFactory.createListOfRate();
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

