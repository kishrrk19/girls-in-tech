package co.simplon.girls_in_tech_business.controllers;

import co.simplon.girls_in_tech_business.dtos.AnswerCreate;
import co.simplon.girls_in_tech_business.dtos.AnswerView;
import co.simplon.girls_in_tech_business.services.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/question/answer")
public class AnswerController {

    private final AnswerService service;

    public AnswerController(AnswerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> createAnswer(@RequestBody AnswerCreate inputs){
        service.create(inputs);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<HashSet<AnswerView>> getAnswersByQuestion(@PathVariable Long questionId){
        List<AnswerView> answers = service.getAllAnswersByQuestion(questionId);
        return ResponseEntity.ok(new HashSet<>(answers));
    }
}
