package com.qa.people.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.people.dto.PersonReqDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // loads the app context with all your beans
@AutoConfigureMockMvc // sets up the testing library
public class PersonIntegrationTest {

    @Autowired // tells Spring to inject the mvc object into my test class
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        // body, method, url, content-type
        PersonReqDTO newPerson = new PersonReqDTO("Jordan", 28, "Trainer", "Mind your own business");
        String newPersonAsJSON = this.mapper.writeValueAsString(newPerson);
        System.out.println("JSON: " + newPersonAsJSON);
        RequestBuilder req = MockMvcRequestBuilders.post("/create").content(newPersonAsJSON).contentType(MediaType.APPLICATION_JSON);
    }
}
