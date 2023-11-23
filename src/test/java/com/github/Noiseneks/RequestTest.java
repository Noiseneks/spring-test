package com.github.Noiseneks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/")
                .queryParam("line", "aaaaabbbbccc")
                .accept(MediaType.APPLICATION_JSON);

        String jsonExample = "{\"a\":5,\"b\":4,\"c\":3}";

        mvc.perform(requestBuilder)
                        .andExpect(status().isOk())
                        .andExpect(content().json(jsonExample));
    }

}
