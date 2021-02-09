package com.galvanize.speedway.IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.speedway.entities.Racecar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class SpeedwayIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void addRaceCarsTest() throws Exception{

        Racecar racecar = new Racecar();
        racecar.setName("Ferrari");

        mockMvc.perform(post("/api/v1/racecars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(racecar)))
                .andExpect(status().isCreated());
    }
}