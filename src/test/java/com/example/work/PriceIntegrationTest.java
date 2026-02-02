package com.example.work;

import com.example.work.adapter.domain.response.GetProductResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @CsvSource({
            // date, productId, chainId, expectedRate, expectedPrice, expectedListSize
            "2020-06-14T10:00:00, 35455, 1, 1, 35.50, 1",
            "2020-06-14T16:00:00, 35455, 1, 2, 25.45, 2",
            "2020-06-14T21:00:00, 35455, 1, 1, 35.50, 1",
            "2020-06-15T10:00:00, 35455, 1, 3, 30.50, 2",
            "2020-06-16T21:00:00, 35455, 1, 4, 38.95, 2"
    })
    void shouldReturnCorrectPrice(
            String date,
            Long productId,
            Long chainId,
            BigDecimal expectedRate,
            BigDecimal expectedPrice,
            int expectedListSize
    ) throws Exception {

        String url = String.format(
                "/v1/prices?date=%s&productId=%d&chainId=%d",
                date, productId, chainId
        );

        // Perform GET request
        String jsonResponse = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Convert JSON to List<GetProductResponse>
        List<GetProductResponse> response =
                objectMapper.readValue(jsonResponse, new TypeReference<List<GetProductResponse>>() {});

        // Assertions
        assertThat(response).isNotNull();
        assertThat(response.size()).isGreaterThan(0);
        assertThat(response.size()).isEqualTo(expectedListSize);

        // Check first item
        GetProductResponse first = response.get(0);
        assertThat(first.rate()).isEqualTo(expectedRate);
        assertThat(first.price()).isEqualTo(expectedPrice);

    }
}
