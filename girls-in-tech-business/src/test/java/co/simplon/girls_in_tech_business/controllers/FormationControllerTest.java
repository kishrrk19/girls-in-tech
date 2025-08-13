package co.simplon.girls_in_tech_business.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FormationControllerTest {

    @Autowired
    private MockMvc mvcServeur;

    //pour tester si le spec marche bien, je n'ai pas besoin de test unitaire

    @DisplayName("Should return Formation associated with ID")
    @Test
    void shouldGetFormationDetail() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.request(HttpMethod.GET, "/formation/4");
        ResultActions result = mvcServeur.perform(builder);
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.formationName").value("Ingénieur Généraliste"));
    }

    @DisplayName("Recherche Formations : Should return all formations that have key words of input")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/RechercheFormation/search-formation-valid.csv", numLinesToSkip = 1,
            delimiter = '§')
    void shouldGetAllFormationWithCriteria(String json, int total) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.request(HttpMethod.POST, "/formation/search").contentType(MediaType.APPLICATION_JSON).content(json);
        ResultActions result = mvcServeur.perform(builder);
        result.andExpect(status().isOk()).andExpect(jsonPath("$.total").value(total));
    }

    @DisplayName("Recherche Formations : Should return Bad request when input's caracters number is more than number of caracters of validation")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/RechercheFormation/search-formation-not-valid.csv", numLinesToSkip = 1)
    void shouldReturnBadRequestWhenOverCaractersValidation(String json) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.request(HttpMethod.POST, "/formation/search").contentType(MediaType.APPLICATION_JSON).content(json);
        ResultActions result = mvcServeur.perform(builder);
        result.andExpect(status().isBadRequest());
    }

    @DisplayName("Create Formation Simplon and then Search Simplon")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/RechercheFormation/creation-search-valid.csv", numLinesToSkip = 1, delimiter = '§')
    void shouldReturnTotal1AfterCreatedFormation(String creationJson, String searchJson) throws Exception {
        MockHttpServletRequestBuilder builderCreation = MockMvcRequestBuilders.request(HttpMethod.POST, "/formation/create").contentType(MediaType.APPLICATION_JSON).content(creationJson);
        mvcServeur.perform(builderCreation);
        MockHttpServletRequestBuilder builderSearch = MockMvcRequestBuilders.request(HttpMethod.POST,"/formation/search").contentType(MediaType.APPLICATION_JSON).content(searchJson);
        ResultActions result = mvcServeur.perform(builderSearch);
        result.andExpect(jsonPath("$.total").value(1));
    }

}