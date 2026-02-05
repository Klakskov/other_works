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
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.work.adapter.errors.ErrorsCode.BR001;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GetPriceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @CsvSource({
            // date, productId, chainId, expectedRate, expectedPrice, expectedListSize
            "2020-06-14T10:00:00, 35455, 1, 1, 35.50",
            "2020-06-14T16:00:00, 35455, 1, 2, 25.45",
            "2020-06-14T21:00:00, 35455, 1, 1, 35.50",
            "2020-06-15T10:00:00, 35455, 1, 3, 30.50",
            "2020-06-16T21:00:00, 35455, 1, 4, 38.95"
    })
    void shouldReturnCorrectPrice(
            String date,
            String productId,
            String chainId,
            BigDecimal expectedRate,
            BigDecimal expectedPrice
    ) throws Exception {
        // Perform GET request
        String jsonResponse = mockMvc.perform(get(buildUrl(date, productId, chainId)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Convert JSON to List<GetProductResponse>
        GetProductResponse response =
                objectMapper.readValue(jsonResponse, new TypeReference<GetProductResponse>() {
                });

        // Assertions
        assertThat(response).isNotNull();
        assertThat(response.rate()).isEqualTo(expectedRate);
        assertThat(response.price()).isEqualTo(expectedPrice);

    }

    @ParameterizedTest
    @CsvSource(value = {
            ", 35455, 1",
            "2020-06-14T16:00:00, , 1",
            "2020-06-14T21:00:00, 35455, "
    })
    void checkBadRequest(String date, String productId, String chainId) throws Exception {

        mockMvc.perform(get(buildUrl(date, productId, chainId)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.httpStatus").value("400"))
                .andExpect(jsonPath("$.errorCode").value(BR001.name()));
    }


    private String buildUrl(String date, String productId, String chainId) {

        Map<String, Object> params = new HashMap<>();
        params.put("date", date);
        params.put("productId", productId);
        params.put("chainId", chainId);

        String query = params.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));

        return query.isBlank()
                ? "/v1/prices"
                : "/v1/prices?" + query;
    }
}
