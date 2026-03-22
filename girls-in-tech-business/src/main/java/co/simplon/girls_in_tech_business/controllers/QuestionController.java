package co.simplon.girls_in_tech_business.controllers;

import co.simplon.girls_in_tech_business.dtos.QuestionCreate;
import co.simplon.girls_in_tech_business.dtos.QuestionView;
import co.simplon.girls_in_tech_business.services.QuestionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createQuestion(@Valid @RequestBody QuestionCreate inputs){
        service.create(inputs);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("allQuestion/{formationId}")
    public ResponseEntity<HashSet<QuestionView>> getQuestionsByFormation(@PathVariable Long formationId){
        List<QuestionView> questions = service.getAllQuestionByFormation(formationId);
        return ResponseEntity.ok(new HashSet<>(questions));
    }

}
