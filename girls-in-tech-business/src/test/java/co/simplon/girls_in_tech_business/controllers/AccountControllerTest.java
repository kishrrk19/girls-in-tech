package co.simplon.girls_in_tech_business.controllers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AccountControllerTest {

    @Autowired
    private MockMvc mvcServeur;

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/CreateAccount/create-account-valid.csv", delimiter = '§')
    void shouldReturnCreated(String json) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.request(HttpMethod.POST,"/account/creer-compte").contentType(MediaType.APPLICATION_JSON).content(json);
        ResultActions result = mvcServeur.perform(builder);
        result.andExpect(status().isCreated());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/CreateAccount/create-account-not-valid.csv", delimiter = '§')
    void shouldReturnConflict(String json) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.request(HttpMethod.POST,"/account/creer-compte").contentType(MediaType.APPLICATION_JSON).content(json);
        ResultActions result = mvcServeur.perform(builder);
        result.andExpect(status().isConflict());
    }

}