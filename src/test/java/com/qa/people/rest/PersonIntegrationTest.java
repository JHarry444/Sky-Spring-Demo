//package com.qa.people.rest;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.qa.people.dto.PersonDTO;
//import com.qa.people.dto.PersonReqDTO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // loads the app context with all your beans
//@AutoConfigureMockMvc // sets up the testing library
//@Sql(scripts = {"classpath:person-schema.sql", "classpath:person-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//public class PersonIntegrationTest {
//
//    @Autowired // tells Spring to inject the mvc object into my test class
//    private MockMvc mvc;
//
//    @Autowired // <--------
//    private ObjectMapper mapper;
//
//    @Test
//    void testCreate() throws Exception {
//        // SETTING UP THE REQUEST
//        PersonReqDTO newPerson = new PersonReqDTO("Jordan", 28, "Trainer", "Mind your own business");
//        String newPersonAsJSON = this.mapper.writeValueAsString(newPerson);
////        System.out.println("JSON: " + newPersonAsJSON);
//        // method, url, body, content-type
//        RequestBuilder req = post("/create").content(newPersonAsJSON).contentType(MediaType.APPLICATION_JSON);
//        // CHECK THE RESPONSE STATUS
//
//        ResultMatcher checkStatus = status().isCreated();
//        // CHECK THE RESPONSE BODY
//        PersonDTO created = new PersonDTO("Jordan", 28, "Trainer");
//        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(created));
//        // DO THE REQ AND CHECK THE RESPONSE
//        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//    }
//
//
//    @Test
//    void testGet() throws Exception {
//
//        RequestBuilder req = MockMvcRequestBuilders.get("/get/1");
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
//        PersonDTO person = new PersonDTO("JB", 24, "Trainer");
//        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(person));
//
//        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//    }
//
//    @Test
//    void testGetAll() throws Exception {
//
//        RequestBuilder req = MockMvcRequestBuilders.get("/getAll");
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
//        PersonDTO person = new PersonDTO("JB", 24, "Trainer");
//        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(List.of(person)));
//
//        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//    }
//
//    @Test
//    void testUpdate() throws Exception {
//
//        RequestBuilder req = MockMvcRequestBuilders.patch("/update/1").queryParam("name", "Jordan B");
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
//        PersonDTO person = new PersonDTO("Jordan B", 24, "Trainer");
//        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(person));
//
//        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//    }
//
//    @Test
//    void testDelete() throws Exception {
//
//        RequestBuilder req = MockMvcRequestBuilders.delete("/remove/1");
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
//        PersonDTO person = new PersonDTO("JB", 24, "Trainer");
//        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(person));
//
//        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
//    }
//}
