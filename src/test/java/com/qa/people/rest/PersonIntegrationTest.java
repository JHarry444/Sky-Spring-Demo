package com.qa.people.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.people.dto.PersonDTO;
import com.qa.people.dto.PersonReqDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // loads the app context with all your beans
@AutoConfigureMockMvc // sets up the testing library
@Sql(scripts = {"classpath:person-schema.sql", "classpath:person-data.sql"})
public class PersonIntegrationTest {

    @Autowired // tells Spring to inject the mvc object into my test class
    private MockMvc mvc;

    @Autowired // <--------
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        // SETTING UP THE REQUEST
        PersonReqDTO newPerson = new PersonReqDTO("Jordan", 28, "Trainer", "Mind your own business");
        String newPersonAsJSON = this.mapper.writeValueAsString(newPerson);
//        System.out.println("JSON: " + newPersonAsJSON);
        // method, url, body, content-type
        RequestBuilder req = post("/create").content(newPersonAsJSON).contentType(MediaType.APPLICATION_JSON);
        // CHECK THE RESPONSE STATUS

        ResultMatcher checkStatus = status().isCreated();
        // CHECK THE RESPONSE BODY
        PersonDTO created = new PersonDTO("Jordan", 28, "Trainer");
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(created));
        // DO THE REQ AND CHECK THE RESPONSE
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
}
