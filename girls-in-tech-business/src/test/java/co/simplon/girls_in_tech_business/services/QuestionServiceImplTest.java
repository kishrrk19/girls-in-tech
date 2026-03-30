package co.simplon.girls_in_tech_business.services;

import co.simplon.girls_in_tech_business.repositories.AccountJPARepository;
import co.simplon.girls_in_tech_business.repositories.FormationJPARepository;
import co.simplon.girls_in_tech_business.repositories.QuestionJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class QuestionServiceImplTest {

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionJPARepository questionJPARepository;

    @Mock
    private AccountJPARepository accountJPARepository;

    @Mock
    private FormationJPARepository formationJPARepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }



}
